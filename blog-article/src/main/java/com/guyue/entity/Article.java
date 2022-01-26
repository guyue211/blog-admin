package com.guyue.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Article {
    //文章id
    private Integer id;
    //文章标题
    private String title;
    //文章内容
    private String content;
    //文章创建时间
    @JsonFormat(pattern = "yyyy.M.d")
    private Date createTime;
    //文章更新时间
    @JsonFormat(pattern = "yyyy.M.d")
    private Date updateTime;
    //文章分类
    private Category category;
    //文章作者
    private String author;
    //文章喜欢数
    private Integer likeNum;
    //文章浏览量
    private Integer pageViews;
    //文章uuid
    private String articleUUID;
    //评论
    private List<Comment> comments;
    //标签
    private List<Label> labels;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", category=" + category +
                ", author='" + author + '\'' +
                ", likeNum=" + likeNum +
                ", pageViews=" + pageViews +
                ", articleUUID='" + articleUUID + '\'' +
                ", comments=" + comments +
                ", labels=" + labels +
                '}';
    }

    public Article() {
    }

    public Article(Integer id, String title, String content, Date createTime, Date updateTime, Category category, String author, Integer likeNum, Integer pageViews, String articleUUID,List<Comment> comments, List<Label> labels) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.category = category;
        this.author = author;
        this.likeNum = likeNum;
        this.pageViews = pageViews;
        this.articleUUID = articleUUID;
        this.comments = comments;
        this.labels = labels;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        if (createTime==null){
            this.createTime =new Date();
        }else {
            this.createTime = createTime;
        }
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        if (updateTime==null){
            this.updateTime =new Date();
        }else {
            this.updateTime = updateTime;
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Integer getPageViews() {
        return pageViews;
    }

    public void setPageViews(Integer pageViews) {
        this.pageViews = pageViews;
    }

    public String getArticleUUID() {
        return articleUUID;
    }

    public void setArticleUUID(String articleUUID) {
        if (articleUUID == null || articleUUID.equals("")) {
            this.articleUUID = UUID.randomUUID().toString();
        } else {
            this.articleUUID = articleUUID;
        }
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments( List<Comment> comments) {
        if (labels.size()>0){
            this.comments = comments;
        }
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        if (labels.size()>0){
            this.labels = labels;
        }
    }
}
