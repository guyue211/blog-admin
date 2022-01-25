package com.guyue.mapper;

import com.guyue.entity.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@Repository
public interface CommentMapper {
    List<Comment> getCommentsByAid(@Param("aid") Integer aid);
    List<Comment> getParentComment(@Param("id") Integer parentId);
}
