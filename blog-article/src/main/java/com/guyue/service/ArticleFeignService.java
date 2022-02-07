package com.guyue.service;

import com.guyue.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author tokyo
 * @date 2022/1/25
 */
@FeignClient(name = "blog-article")
public interface ArticleFeignService {
    @PutMapping("/admin/updateArticleByCid")
    Result updateArticleByCid(@RequestParam("id") Integer cid);
}
