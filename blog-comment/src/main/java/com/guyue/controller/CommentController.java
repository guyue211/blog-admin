package com.guyue.controller;

import com.guyue.entity.Comment;
import com.guyue.service.CommentService;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@RestController
public class CommentController {
    @Autowired
    private CommentService service;
    @GetMapping("/admin/getComments")
    List<Comment> getComments(@RequestParam("id") Integer aid){
       return service.getComments(aid);
    }
}
