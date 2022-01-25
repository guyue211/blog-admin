package com.guyue.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@Component
public class Category {
    //分类id
    private Integer id;
    //分类名
    private String name;
    //分类创建时间
    @JsonFormat(pattern = "yyyy.M.d", timezone = "GMT+8")
    private Date create_time;

    public Category() {
    }

    public Category(Integer id, String name, Date create_time) {
        this.id = id;
        this.name = name;
        this.create_time = create_time;
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

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}
