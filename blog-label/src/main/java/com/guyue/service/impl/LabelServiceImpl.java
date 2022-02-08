package com.guyue.service.impl;

import com.guyue.eneity.ArticleLabel;
import com.guyue.entity.Label;
import com.guyue.mapper.LabelMapper;
import com.guyue.service.LabelService;
import com.guyue.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelMapper mapper;
    @Autowired
    private RedisUtil redisUtil;
    /**
     * 查询所有标签
     *
     * @return
     */
    @Override
    public List<Label> getLabels() {
        //查缓存
        System.out.println("进来了");
        Map<Object, Object> labels = redisUtil.hEntries("labels");
        List<Label> labelsList = new ArrayList<>();
        if (labels.size()>0){
            for (Map.Entry<Object, Object> entry : labels.entrySet()) {
                labelsList.add((Label) entry.getValue());
            }
            return labelsList;
        }
        labelsList = mapper.getLabels();
        Map<String, Object> labelsMap=new HashMap<>();
        for (Label label : labelsList) {
            labelsMap.put(String.valueOf(label.getId()),label);
        }
        //没缓存就更新缓存
        redisUtil.hPutAll("labels",labelsMap);
        System.out.println(labelsList);
        return labelsList;
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
        Integer result = mapper.deleteLabel(id);
        //删除缓存
        if (result!=null) redisUtil.hDelete("labels",String.valueOf(id));
        return result;
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
        Integer result = mapper.updateLabel(label);
        //更新缓存
        if (result!=null) redisUtil.hPut("labels",String.valueOf(label.getId()),label);
        return result;
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
        Integer result = mapper.addLabel(label);
        //添加缓存
        if (result!=null) redisUtil.hPut("labels",String.valueOf(label.getId()),label);
        return result;
    }
}
