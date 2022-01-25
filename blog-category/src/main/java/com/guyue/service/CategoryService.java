package com.guyue.service;

import com.guyue.entity.Category;

import java.util.List;

/**
 * @author tokyo
 * @date 2022/1/23
 */
public interface CategoryService {
    /**
     * 查询所有类别
     * @return
     */
    List<Category> getCategorys();
}
