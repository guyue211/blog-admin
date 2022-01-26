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
public class Label {
    private Integer id;
    private String name;
    @JsonFormat(pattern = "yyyy.M.d")
    private Date createTime;
    public Label(Integer id, String name, Date createTime) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
    }
    public Label() {
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

    public void setCreateTime(Date createTime) {
        if (createTime==null){
            this.createTime =new Date();
        }else {
            this.createTime = createTime;
        }
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
