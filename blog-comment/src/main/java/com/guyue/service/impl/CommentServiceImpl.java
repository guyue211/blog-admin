package com.guyue.service.impl;

import com.guyue.entity.Comment;
import com.guyue.mapper.CommentMapper;
import com.guyue.service.CommentService;
import com.guyue.utils.RedisUtil;
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
    @Autowired
    private RedisUtil redisUtil;
    @Override
    public List<Comment> getComments(Integer aid) {
        //查看缓存有没有
        List<Comment> comments = (List<Comment>) redisUtil.hGet("comments", String.valueOf(aid));
        //存在就返回
        if (comments!=null) return comments;
        List<Comment> comments1 = mapper.getCommentsByAid(aid);
        //没有就更新缓存
        if (comments1 != null) redisUtil.hPut("comments", String.valueOf(aid),comments1);
        return comments1;
    }

    /**
     * 新增评论
     *
     * @param comment
     * @return
     */
    @Override
    public Integer addComment(Comment comment) {
        Integer result = mapper.addComment(comment);
        //更新缓存
        if (result!=0){
            List<Comment> comments = mapper.getCommentsByAid(comment.getArticleId());
            redisUtil.hPut("comments", String.valueOf(comment.getArticleId()),comments);
        }
        return result;
    }

    /**
     * 更新评论
     *
     * @param comment
     * @return
     */
    @Override
    public Integer updateComment(Comment comment) {
        Integer result = mapper.updateComment(comment);
        //更新缓存
        if (result!=0){
            List<Comment> comments = mapper.getCommentsByAid(comment.getArticleId());
            redisUtil.hPut("comments", String.valueOf(comment.getArticleId()),comments);
        }
        return result;
    }

    /**
     * 删除评论
     *
     * @param id
     * @return
     */
    @Override
    public Integer deleteComment(Integer id) {
        String Aid=mapper.getComment(id);
        Integer result = mapper.deleteComment(id);
        //删除缓存 并重新查询更新缓存  因为无法判断是否有其他评论残留
        redisUtil.hDelete("comments",Aid);
        List<Comment> comments = mapper.getCommentsByAid(Integer.valueOf(Aid));
        //判断有没有其他评论 有就加上缓存
        if (comments!=null)  redisUtil.hPut("comments", String.valueOf(Aid),comments);
        return result;
    }
    /**
     * 根据文章id删对应评论
     * @param aids
     * @return
     */
    @Override
    public Integer deleteCommentByAids(int[] aids) {
        Integer result = mapper.deleteCommentByAids(aids);
        //删除缓存
        for (int aid : aids) {
            redisUtil.hDelete("comments",aid);
        }
        return result;
    }
}
