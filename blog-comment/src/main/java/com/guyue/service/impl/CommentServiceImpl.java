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
}
