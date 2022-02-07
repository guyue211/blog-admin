package com.guyue.service;

import com.guyue.entity.Comment;
import com.guyue.utils.MessageConstant;
import com.guyue.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author tokyo
 * @date 2022/1/25
 */
@FeignClient(name = "blog-comment")
public interface CommentsFeignService {
    @GetMapping("/admin/getComments")
    List<Comment> getComments(@RequestParam("id") Integer aid);

    @DeleteMapping("/admin/deleteCommentByAid/{ids}")
    Result deleteCommentByAid(@PathVariable("ids") int[] aids);
}
