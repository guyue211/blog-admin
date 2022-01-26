package com.guyue.service.impl;

import com.guyue.entity.Category;
import com.guyue.mapper.CategoryMapper;
import com.guyue.service.CategoryService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper mapper;


    /**
     * 查询所有类别
     *
     * @return
     */
    @Override
    public List<Category> getCategorys() {
        return mapper.getCategorys();
    }

    /**
     * 修改分类
     * @param category
     * @return
     */
    @Override
    public Integer updateCategory(Category category) {
        return mapper.updateCategory(category);
    }

    /**
     * 添加类别
     *
     * @param category
     * @return
     */
    @Override
    public Integer addCategory(Category category) {
        return mapper.addCategory(category);
    }

    /**
     * 删除类别
     *
     * @param id
     * @return
     */
    @Override
    public Integer deleteCategory(Integer id) {
        return mapper.deleteCategory(id);
    }
}
