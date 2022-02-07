package com.guyue.service;

import com.guyue.entity.Label;

import java.util.List;

/**
 * @author tokyo
 * @date 2022/1/23
 */
public interface LabelService {
    /**
     * 查询所有标签
     * @return
     */
    List<Label> getLabels();

    /**
     * 删除标签
     * @param id
     * @return
     */
    Integer deleteLabel(Integer id);

    /**
     * 更新标签
     * @param label
     * @return
     */
    Integer updateLabel(Label label);

    /**
     * 添加标签
     * @param label
     * @return
     */
    Integer addLabel(Label label);
}
