package com.guyue.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@Component
public class Comment {
    //评论id
    private Integer id;
    //评论人名字
    private String name;
    //评论内容
    private String content;
    //评论人头像
    private String photo;
    //评论人邮箱
    private String email;
    //评论时间
    @JsonFormat(pattern = "yyyy.M.d", timezone = "GMT+8")
    private Date create_time;
    //父评论id
    private Integer parent_id;
    //评论绑定文章id
    private Integer article_id;
    //子评论
    private List<Comment> comments;

    public Comment() {
  }

    public Comment(Integer id, String name, String content, String photo, String email, Date create_time, Integer parent_id, Integer article_id, List<Comment> comments) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.photo = photo;
        this.email = email;
        this.create_time = create_time;
        this.parent_id = parent_id;
        this.article_id = article_id;
        this.comments = comments;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", photo='" + photo + '\'' +
                ", email='" + email + '\'' +
                ", create_time=" + create_time +
                ", parent_id=" + parent_id +
                ", article_id=" + article_id +
                ", comments=" + comments +
                '}';
    }
}
