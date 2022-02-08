package com.guyue.service.impl;

import com.guyue.entity.Category;
import com.guyue.mapper.CategoryMapper;
import com.guyue.service.CategoryService;
import com.guyue.utils.RedisUtil;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper mapper;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 查询所有类别
     *
     * @return
     */
    @Override
    public List<Category> getCategories() {
        //看看redis有没有 无则添加 有则直接返回
        Map<Object, Object> categorys = redisUtil.hEntries("categories");
        List<Category> categorys1 = new ArrayList<>();
        if (categorys.size()>0){
            for (Map.Entry<Object, Object> objectObjectEntry : categorys.entrySet()) {
                categorys1.add((Category) objectObjectEntry.getValue());
            }
            return categorys1;
        }
        //没缓存就更新
        List<Category> categorys2 = mapper.getCategories();
        HashMap<String, Object> map = new HashMap<>();
        for (Category category : categorys2) {
            map.put(String.valueOf(category.getId()),category);
        }
        redisUtil.hPutAll("categories",map);
        return categorys2;
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
        Integer result = mapper.updateCategory(category);
        //更新缓存
        if (result!=0) redisUtil.hPut("categories", String.valueOf(category.getId()),category);
        return result;
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
        Integer result = mapper.addCategory(category);
        if (result!=0) redisUtil.hPut("categories", String.valueOf(category.getId()),category);
        return result;
    }

    /**
     * 删除类别
     *
     * @param id
     * @return
     */
    @Override
    public Integer deleteCategory(Integer id) {
        Integer result = mapper.deleteCategory(id);
        //删除缓存
        if (result!=0) redisUtil.hDelete("categories",id);
        return result;
    }

    @Override
    public Category getCategoryByName(String name) {
        return mapper.getCategoryByName(name);
    }
}
