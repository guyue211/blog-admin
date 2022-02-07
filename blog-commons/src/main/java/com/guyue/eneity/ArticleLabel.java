package com.guyue.eneity;

/**
 * @author tokyo
 * @date 2022/1/28
 */
public class ArticleLabel {
    private Integer id;
    private Integer articleId;
    private Integer labelId;

    public ArticleLabel() {
    }

    public ArticleLabel(Integer id, Integer articleId, Integer labelId) {
        this.id = id;
        this.articleId = articleId;
        this.labelId = labelId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }
}
