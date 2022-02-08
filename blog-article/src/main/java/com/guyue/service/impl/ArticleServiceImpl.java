package com.guyue.service.impl;

import com.guyue.eneity.ArticleLabel;
import com.guyue.entity.Article;
import com.guyue.entity.Label;
import com.guyue.mapper.ArticleMapper;
import com.guyue.service.ArticleService;
import com.guyue.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.guyue.utils.PageInfo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper mapper;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 文章逻辑分页
     * @param pageInfo
     * @return
     */
    @Override
    public List<Article> getArticles(PageInfo pageInfo) {
        List<Article> articles=new ArrayList<>();
        // 获取起点
        int pageStart = (pageInfo.getCurrentPage()-1) * pageInfo.getCurrentCount();
        // 获取终点
        int pageStop = pageStart + pageInfo.getCurrentCount();
        //所有文章
        Map<Object, Object> articles1 = redisUtil.hEntries("articles");
        System.out.println(articles1.size());
        //判断缓存的数据数量是否正确  不正确就得更新缓存
        if (articles1.size()>0 && articles1.size()>=pageStart){
            for (Map.Entry<Object, Object> objectObjectEntry : articles1.entrySet()) {
                articles.add((Article) objectObjectEntry.getValue());
            }

        }else {
            articles= mapper.getArticles();
            //没有缓存就添加articles
            HashMap<String, Object> map = new HashMap<>();
            for (Article article : articles) {
                map.put(String.valueOf(article.getId()),article);
            }
            redisUtil.hPutAll("articles", map);
        }
        //进行排序  id大的最新发布 排前面
        Collections.sort(articles);
        //分页后文章数据
        List<Article> articleList = new ArrayList<>();
        //每页条数
        Integer currentCount = pageInfo.getCurrentCount();
        //获取总页数
        if (articles.size()%currentCount!=0){
            pageInfo.setTotalPage(articles.size()/ currentCount+1);
        }else {
            pageInfo.setTotalPage(articles.size()/ currentCount);
        }
        //获取总条数
        pageInfo.setTotalRecord(articles.size());
        //判断分页总数大于实际总条数 则返回错误
        if(pageInfo.getCurrentPage()*pageInfo.getCurrentCount()>articles.size()) return null;
        // 开始遍历
        while (pageStart < pageStop) {
            // 最后一页可能不够
            if (pageStart == articles.size()) {
                break;
            }
            articleList.add(articles.get(pageStart++));
        }
        return articleList;
    }

    /**
     * 发表文章
     *
     * @param article
     * @return
     */
    @Override
    public int addArticle(Article article) {
        int result = mapper.addArticle(article);
        //有新增的标签需要在中间表建立联系
        List<Label> labels = article.getLabels();
        if (labels.size()>0){
            List<ArticleLabel> articleLabels = new ArrayList<>();
            for (Label label : labels) {
                articleLabels.add(new ArticleLabel(null,article.getId(),label.getId()));
            }
            Integer integer = mapper.addArticleLid(articleLabels);
            if (integer==0)return -1;
        }
        Article article1 = mapper.getArticle(article.getId());
        //执行完添加到redis中articles中
        redisUtil.hPut("articles", String.valueOf(article.getId()),article1);
        return result;
    }

    @Override
    public int updateArticle(Article article) {
        int i = mapper.updateArticle(article);
        Article article1 =mapper.getArticle(article.getId());
        //更新articles
        redisUtil.hPut("articles", String.valueOf(article.getId()),article1);
        return i;
    }

    @Override
    public int deleteArticle(int[] ids) {
        //查询有无依赖关系 删除文章标签依赖关系
        List<ArticleLabel> articleLabels = mapper.getArticlesByIds(ids);
        if (articleLabels.size()>0){
            Integer result=mapper.deleteArticleLabel(ids);
            if (result==0)return -1;
        }
        List<Article> articles = getArticleByIds(ids);
        for (Article article : articles) {
            //删除articles对应文章
            redisUtil.hDelete("articles", String.valueOf(article.getId()));
        }
        return mapper.deleteArticle(ids);
    }

    public List<Article> getArticleByIds(int[] ids) {
        return mapper.getArticleByIds(ids);
    }

    @Override
    public Article getArticle(Integer id) {
        //先看redis有无缓存  有则返回 无则更新
        Article article = (Article) redisUtil.hGet("articles", String.valueOf(id));
        if (article!=null) return  article;
        Article article1 = mapper.getArticle(id);
        //无则更新
        redisUtil.hPut("articles", String.valueOf(article1.getId()),article1);
        return article1;
    }


    /**
     * 处理删除分类时候  同时删除文章依赖cid
     *
     * @param cid
     * @return
     */
    @Override
    public Integer updateArticleByCid(Integer cid) {
        return mapper.updateArticleByCid(cid);
    }

}
