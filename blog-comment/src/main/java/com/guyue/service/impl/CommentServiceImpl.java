package com.guyue.service.impl;

import com.guyue.entity.Comment;
import com.guyue.mapper.CommentMapper;
import com.guyue.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper mapper;
    @Override
    public List<Comment> getComments(Integer aid) {
        System.out.println("a: "+mapper.getCommentsByAid(aid));
        return mapper.getCommentsByAid(aid);
    }

    /**
     * 新增评论
     *
     * @param comment
     * @return
     */
    @Override
    public Integer addComment(Comment comment) {
        return mapper.addComment(comment);
    }

    /**
     * 更新评论
     *
     * @param comment
     * @return
     */
    @Override
    public Integer updateComment(Comment comment) {
        return mapper.updateComment(comment);
    }

    /**
     * 删除评论
     *
     * @param id
     * @return
     */
    @Override
    public Integer deleteComment(Integer id) {
        //检查是否有子评论  删除
            mapper.deleteCommentByPid(id);
        return mapper.deleteComment(id);
    }
    /**
     * 根据文章id删对应评论
     * @param aids
     * @return
     */
    @Override
    public Integer deleteCommentByAids(int[] aids) {
        return mapper.deleteCommentByAids(aids);
    }
}
