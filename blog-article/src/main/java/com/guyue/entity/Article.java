package com.guyue.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@Component
public class Article{
    //文章id
    private Integer id;
    //文章标题
    private String title;
    //文章内容
    private String content;
    //文章创建时间
    @JsonFormat(pattern = "yyyy.M.d", timezone = "GMT+8")
    private Date createTime;
    //文章更新时间
    @JsonFormat(pattern = "yyyy.M.d", timezone = "GMT+8")
    private Date updateTime;
    //文章分类id
    private Integer categoryId;
    //文章作者
    private String author;
    //文章喜欢数
    private Integer like;
    //文章浏览量
    private Integer pageViews;
    //文章uuid
    private String articleUUID;
}
