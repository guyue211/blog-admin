package com.guyue.controller;

import com.guyue.entity.Category;
import com.guyue.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.guyue.utils.MessageConstant;
import com.guyue.utils.Result;

import java.util.List;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@RestController
public class CategoryController {
    @Autowired
    private CategoryService service;

    /**
     * 查询所有分类
     * @return
     */
    @GetMapping("/admin/getCategorys")
    public Result getCategorys(){
        List<Category> categories=service.getCategorys();
        if (categories==null)return new Result(500, MessageConstant.SELECT_CATEGORY_FALL);
        return new Result(200, MessageConstant.SELECT_CATEGORY_SUSSES,categories);
    }

    /**
     * 更新分类信息
     * @param category
     * @return
     */
    @PutMapping("/admin/updateCategory")
    public Result updateCategory(@RequestBody Category category){
        Integer result =service.updateCategory(category);
        if (result==0) return new Result(400, MessageConstant.UPDATE_CATEGORY_FALL);
        return new Result(200, MessageConstant.UPDATE_CATEGORY_SUSSES);
    }


    /**
     * 新增分类
     * @param category
     * @return
     */
    @PostMapping("/admin/addCategory")
    public Result addCategory(@RequestBody Category category){
        Integer result =service.addCategory(category);
        if (result==0) return new Result(400, MessageConstant.ADD_CATEGORY_FALL);
        return new Result(200, MessageConstant.ADD_CATEGORY_SUSSES);
    }

    /**
     * 删除类别  根据id
     * @param id
     * @return
     */
    @DeleteMapping("/admin/deleteCategory/{id}")
    public Result deleteCategory(@PathVariable("id") Integer id){
        Integer result =service.deleteCategory(id);
        if (result==0) return new Result(400, MessageConstant.DELETE_CATEGORY_FALL);
        return new Result(200, MessageConstant.DELETE_CATEGORY_SUSSES);
    }

}
