package com.guyue.controller;

import com.guyue.entity.Category;
import com.guyue.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.MessageConstant;
import utils.Result;

import java.util.List;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@RestController
public class CategoryController {
    @Autowired
    private CategoryService service;
    @GetMapping("/admin/getCategorys")
    public Result getCategorys(){
        List<Category> categories=service.getCategorys();
        if (categories==null)return new Result(500, MessageConstant.SELECT_SORT_FALL);
        return new Result(200, MessageConstant.SELECT_SORT_SUSSES,categories);
    }

}
