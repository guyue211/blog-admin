package com.guyue.service;

import com.guyue.entity.Article;
import utils.PageInfo;

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

    int updateArticle(Article article);

    int deleteArticle(int[] ids);

    Article getArticle(Integer id);
}
