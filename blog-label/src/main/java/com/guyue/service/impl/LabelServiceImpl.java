package com.guyue.service.impl;

import com.guyue.eneity.ArticleLabel;
import com.guyue.entity.Label;
import com.guyue.mapper.LabelMapper;
import com.guyue.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelMapper mapper;
    /**
     * 查询所有标签
     *
     * @return
     */
    @Override
    public List<Label> getLabels() {
        return mapper.getLabels();
    }

    /**
     * 删除标签
     *
     * @param id
     * @return
     */
    @Override
    public Integer deleteLabel(Integer id) {
        //查有无文章依赖关系  有则一并删除
        List<ArticleLabel> articleLabels= mapper.getArticleLabel(id);
        if (articleLabels.size()>0){
            Integer result=mapper.deleteArticleLabelByLid(id);
            if (result==0) return -1;
        }
        return mapper.deleteLabel(id);
    }

    /**
     * 更新标签
     *
     * @param label
     * @return
     */
    @Override
    public Integer updateLabel(Label label) {
        //判断有没有这个名字的标签
        Label label1=mapper.getLabelByName(label.getName());
        if (label1!=null && !Objects.equals(label1.getId(), label.getId()))return -1;
        return mapper.updateLabel(label);
    }

    /**
     * 添加标签
     *
     * @param label
     * @return
     */
    @Override
    public Integer addLabel(Label label) {
        //判断有没有这个名字的标签
        Label label1=mapper.getLabelByName(label.getName());
        if (label1!=null)return -1;
        return mapper.addLabel(label);
    }
}
