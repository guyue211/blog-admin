package com.guyue.controller;

import com.guyue.entity.Category;
import com.guyue.service.CategoryService;
import javafx.scene.chart.CategoryAxis;
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
@RequestMapping("/admin")
public class CategoryController {
    @Autowired
    private CategoryService service;

    /**
     * 查询所有分类
     * @return
     */
    @GetMapping("/getCategorys")
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
    @PutMapping("/updateCategory")
    public Result updateCategory(@RequestBody Category category){
        Integer result =service.updateCategory(category);
        if (result==-1) return new Result(401, MessageConstant.UPDATE_CATEGORY_REPEAT);
        if (result==0) return new Result(400, MessageConstant.UPDATE_CATEGORY_FALL);
        return new Result(200, MessageConstant.UPDATE_CATEGORY_SUSSES);
    }


    /**
     * 新增分类
     * @param category
     * @return
     */
    @PostMapping("/addCategory")
    public Result addCategory(@RequestBody Category category){
        Integer result =service.addCategory(category);
        if (result==-1) return new Result(401, MessageConstant.ADD_CATEGORY_REPEAT);
        if (result==0) return new Result(400, MessageConstant.ADD_CATEGORY_FALL);
        return new Result(200, MessageConstant.ADD_CATEGORY_SUSSES);
    }

    /**
     * 删除类别  根据id
     * @param id
     * @return
     */
    @DeleteMapping("/deleteCategory/{id}")
    public Result deleteCategory(@PathVariable("id") Integer id){
        //删文章依赖的分类
        Integer result =service.deleteCategory(id);
        if (result==0) return new Result(400, MessageConstant.DELETE_CATEGORY_FALL);
        return new Result(200, MessageConstant.DELETE_CATEGORY_SUSSES);
    }

    @GetMapping("/getCategoryByName/{name}")
    public Category getCategoryByName(@PathVariable("name") String name){
        Category category=service.getCategoryByName(name);
        return category;
    }
}
