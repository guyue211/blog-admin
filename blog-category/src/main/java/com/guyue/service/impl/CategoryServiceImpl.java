package com.guyue.service.impl;

import com.guyue.entity.Category;
import com.guyue.mapper.CategoryMapper;
import com.guyue.service.CategoryService;
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
}
