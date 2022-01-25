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
}
