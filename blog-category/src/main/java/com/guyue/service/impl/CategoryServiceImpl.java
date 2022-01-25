package com.guyue.service.impl;

import com.guyue.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@Service
public class CategoryServiceImpl {
    @Autowired
    private CategoryMapper mapper;
}
