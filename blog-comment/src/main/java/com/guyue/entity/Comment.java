package com.guyue.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonFormat(pattern = "yyyy.M.d")
    private Date createTime;
    //父评论id
    private Integer parentId;
    //评论绑定文章id
    private Integer articleId;
    //子评论
    private List<Comment> comments;

    public Comment() {
  }

    public Comment(Integer id, String name, String content, String photo, String email, Date createTime, Integer parentId, Integer articleId, List<Comment> comments) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.photo = photo;
        this.email = email;
        this.createTime = createTime;
        this.parentId = parentId;
        this.articleId = articleId;
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
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
                ", createTime=" + createTime +
                ", parentId=" + parentId +
                ", articleId=" + articleId +
                ", comments=" + comments +
                '}';
    }
}
