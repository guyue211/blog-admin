package com.guyue.controller;

import com.guyue.entity.Comment;
import com.guyue.service.CommentService;
import com.guyue.utils.MessageConstant;
import com.guyue.utils.Result;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@RestController
public class CommentController {
    @Autowired
    private CommentService service;

    /**
     * 查文章下评论
     * @param aid
     * @return
     */
    @GetMapping("/admin/getComments")
    List<Comment> getComments(@RequestParam("id") Integer aid){
       return service.getComments(aid);
    }

    /**
     * 发表评论
     * @param comment
     * @return
     */
    @PostMapping("/admin/addComment")
    public Result addComment(@RequestBody Comment comment){
        Integer result=service.addComment(comment);
        if (result==0)return new Result(400, MessageConstant.RELEASE_COMMENT_FALL);
        return new Result(204, MessageConstant.RELEASE_COMMENT_SUSSES);
    }

    /**
     * 修改评论
     * @param comment
     * @return
     */
    @PutMapping("/admin/updateComment")
    public Result updateComment(@RequestBody Comment comment){
        Integer result=service.updateComment(comment);
        if (result==0)return new Result(400, MessageConstant.UPDATE_COMMENT_FALL);
        return new Result(204, MessageConstant.UPDATE_COMMENT_SUSSES);
    }

    @DeleteMapping("/admin/deleteComment/{id}")
    public Result deleteComment(@PathVariable("id") Integer id){
        Integer result=service.deleteComment(id);
        if (result==0)return new Result(400, MessageConstant.DELETE_COMMENT_FALL);
        return new Result(204, MessageConstant.DELETE_COMMENT_SUSSES);
    }

    /**
     * 根据文章id删除对应评论
     * @param aids
     * @return
     */
    @DeleteMapping("/admin/deleteCommentByAid/{ids}")
    public Result deleteCommentByAid(@PathVariable("ids") int[] aids){
        Integer result=service.deleteCommentByAids(aids);
        if (result==0)return new Result(400, MessageConstant.DELETE_COMMENT_FALL);
        return new Result(204, MessageConstant.DELETE_COMMENT_SUSSES,result);
    }
}
