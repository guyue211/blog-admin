package com.guyue.mapper;

import com.guyue.eneity.ArticleLabel;
import com.guyue.entity.Article;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
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

    /**
     * 查单个文章 通过文章id
     * @param id
     * @return
     */
    Article getArticle(Integer id);

    /**
     * 删除类别时候 把依赖文章的cid改为0
     * @param cid
     * @return
     */
    Integer updateArticleByCid(Integer cid);

    /**
     * 添加文章标签依赖关系
     * @param articleLabels
     * @return
     */
    Integer addArticleLid(List<ArticleLabel> articleLabels);

    /**
     * 删除文章标签依赖关系
     * @param ids
     * @return
     */
    Integer deleteArticleLabel(int[] ids);

    List<ArticleLabel> getArticlesByIds(int[] ids);

    List<Article> getArticleByIds(int[] ids);

}
