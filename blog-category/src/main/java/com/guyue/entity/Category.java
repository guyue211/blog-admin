package com.guyue.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category {
    //分类id
    private Integer id;
    //分类名
    private String name;
    //分类创建时间
    @JsonFormat(pattern = "yyyy.M.d", timezone = "GMT+8")
    private Date createTime;

    public Category() {
    }

    public Category(Integer id, String name, Date createTime) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date create_time) {
        this.createTime = create_time;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
