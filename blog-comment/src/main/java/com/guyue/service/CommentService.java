package com.guyue.service;

import com.guyue.entity.Comment;

import java.util.HashMap;
import java.util.List;

/**
 * @author tokyo
 * @date 2022/1/23
 */
public interface CommentService {
    /**
     * 查 文章下评论
     * @param aid
     * @return
     */
    List<Comment> getComments(Integer aid);

    /**
     * 新增评论
     * @param comment
     * @return
     */
    Integer addComment(Comment comment);

    /**
     * 更新评论
     * @param comment
     * @return
     */
    Integer updateComment(Comment comment);

    /**
     * 删除评论
     * @param id
     * @return
     */
    Integer deleteComment(Integer id);

    /**
     * 根据文章id删对应评论
     * @param aids
     * @return
     */
    Integer deleteCommentByAids(int[] aids);
}
