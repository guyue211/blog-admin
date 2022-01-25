package com.guyue.service;

import com.guyue.entity.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

/**
 * @author tokyo
 * @date 2022/1/25
 */
@FeignClient(name = "blog-comment")
public interface CommentsFeignService {
    @GetMapping("/admin/getComments")
    List<Comment> getComments(@RequestParam("id") Integer aid);
}
