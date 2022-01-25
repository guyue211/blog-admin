package com.guyue.service;

import com.guyue.entity.Comment;

import java.util.HashMap;
import java.util.List;

/**
 * @author tokyo
 * @date 2022/1/23
 */
public interface CommentService {
    List<Comment> getComments(Integer aid);
}
