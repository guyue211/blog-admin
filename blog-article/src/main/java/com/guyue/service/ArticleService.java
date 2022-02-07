package com.guyue.service;

import com.guyue.entity.Article;
import com.guyue.utils.PageInfo;

import java.util.List;

/**
 * @author tokyo
 * @date 2022/1/23
 */
public interface ArticleService {

    /**
     * 查看所有文章 逻辑分页
     * @return
     */
    List<Article> getArticles(PageInfo pageInfo);

    /**
     * 新增文章
     * @param article
     * @return
     */
    int addArticle(Article article);

    /**
     * 更新文章
     * @param article
     * @return
     */
    int updateArticle(Article article);

    /**
     * 删除文章
     * @param ids
     * @return
     */
    int deleteArticle(int[] ids);

    /**
     * 查询单个文章
     * @param id
     * @return
     */
    Object getArticle(Integer id);

    /**
     * 处理删除分类时候  同时删除文章依赖cid
     * @param cid
     * @return
     */
    Integer updateArticleByCid(Integer cid);
}
