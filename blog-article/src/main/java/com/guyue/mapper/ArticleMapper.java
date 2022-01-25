package com.guyue.mapper;

import com.guyue.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@Repository
public interface ArticleMapper {
    /**
     * 查看所有文章
     * @return
     */
    List<Article> getArticles();

    /**
     * 发表文章
     * @param article
     * @return
     */
    int addArticle(Article article);

    /**
     * 修改文章
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
}
