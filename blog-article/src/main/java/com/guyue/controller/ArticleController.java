package com.guyue.controller;

import com.guyue.entity.service.ArticleService;
import com.guyue.entity.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@RestController
public class ArticleController {
    @Autowired
    private ArticleService service;

    @GetMapping("/test")
    public String test(){
        return "hahahah";
    }
}
