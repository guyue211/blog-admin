package com.guyue.service;

import com.guyue.entity.Category;
import com.guyue.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author tokyo
 * @date 2022/1/25
 */
@FeignClient(name = "blog-category")
@RequestMapping("/admin")
public interface CategoryFeignService {

}
