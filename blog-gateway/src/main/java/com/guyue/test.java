package com.guyue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tokyo
 * @date 2022/1/26
 */
@RestController
public class test {
    @Value("${ma:null}")
    private String aa;
    @GetMapping("/a")
    public String test(){
        return aa;
    }
}
