package com.guyue.service.impl;

import com.guyue.entity.Article;
import com.guyue.mapper.ArticleMapper;
import com.guyue.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.PageInfo;
import utils.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper mapper;

    /**
     * 文章逻辑分页
     * @param pageInfo
     * @return
     */
    @Override
    public List<Article> getArticles(PageInfo pageInfo) {

        //所有文章
        List<Article> articles = mapper.getArticles();
        //分页后文章数据
        List<Article> articleList = new ArrayList<>();
        //获取总页数 和总条数
        if (articles.size()%pageInfo.getCurrentCount()!=0){
            pageInfo.setTotalPage(articles.size()/ pageInfo.getCurrentCount()+1);
        }else {
            pageInfo.setTotalPage(articles.size()/ pageInfo.getCurrentCount());
        }
        pageInfo.setTotalRecord(articles.size());
        if(pageInfo.getCurrentPage()*pageInfo.getCurrentCount()>articles.size()) return null;

        // 获取起点
        int pageStart = (pageInfo.getCurrentPage()-1) * pageInfo.getCurrentCount();
        // 获取终点
        int pageStop = pageStart + pageInfo.getCurrentCount();
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
        System.out.println(article);
        return mapper.addArticle(article);
    }

    @Override
    public int updateArticle(Article article) {
        return mapper.updateArticle(article);
    }

    @Override
    public int deleteArticle(int[] ids) {
        return mapper.deleteArticle(ids);
    }
}
