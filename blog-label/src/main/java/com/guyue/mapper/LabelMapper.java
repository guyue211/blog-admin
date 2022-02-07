package com.guyue.mapper;

import com.guyue.eneity.ArticleLabel;
import com.guyue.entity.Label;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@Repository
public interface LabelMapper {
    /**
     * 根据文章id 查所含标签
     * @param aid
     * @return
     */
    List<Label> getLabelByAid(Integer aid);

    List<Label> getLabels();

    Integer addLabel(Label label);

    Integer updateLabel(Label label);

    Integer deleteLabel(Integer id);

    Label getLabelByName(String name);

    List<ArticleLabel> getArticleLabel(Integer lid);

    Integer deleteArticleLabelByLid(Integer lid);
}
