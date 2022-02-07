package com.guyue.mapper;

import com.guyue.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@Repository
public interface CategoryMapper {
    /**
     * id查类别
     * @param id
     * @return
     */
    Category getCategoryById(Integer id);

    /**
     * 获取所有类别
     * @return
     */
    List<Category> getCategorys();

    /**
     * 更新类别
     * @param category
     * @return
     */
    Integer updateCategory(Category category);

    /**
     * 删除类别
     * @param id
     * @return
     */
    Integer deleteCategory(Integer id);

    /**
     * 新增类别
     * @param category
     * @return
     */
    Integer addCategory(Category category);

    /**
     * 根据name查类别
     * @param name
     * @return
     */
    Category getCategoryByName(String name);
}
