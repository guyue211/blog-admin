package com.guyue.service.impl;

import com.guyue.entity.Category;
import com.guyue.mapper.CategoryMapper;
import com.guyue.service.CategoryService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
        //查询分类是否重名
        Category category1=mapper.getCategoryByName(category.getName());
        if (category1!=null && !Objects.equals(category1.getId(), category.getId()))return -1;
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
        //查询分类是否重名
        Category category1=mapper.getCategoryByName(category.getName());
        if (category1!=null)return -1;
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

    @Override
    public Category getCategoryByName(String name) {
        return mapper.getCategoryByName(name);
    }
}
