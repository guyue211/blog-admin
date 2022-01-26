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

    /**
     * 更新类别
     * @param id
     * @return
     */
    Integer updateCategory(Category id);

    /**
     * 添加类别
     * @param category
     * @return
     */
    Integer addCategory(Category category);

    /**
     * 删除类别
     * @param id
     * @return
     */
    Integer deleteCategory(Integer id);
}
