package com.guyue.controller;

import com.guyue.entity.Label;
import com.guyue.service.LabelService;
import com.guyue.utils.MessageConstant;
import com.guyue.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@RestController
@RequestMapping("/admin")
public class LabelController {
    @Autowired
    private LabelService service;

    /**
     * 查询所有标签
     *
     * @return
     */
    @GetMapping("/getLabels")
    public Result getLabels() {
        List<Label> labels = service.getLabels();
        if (labels.size() > 0) {
            return new Result(200, MessageConstant.SELECT_LABEL_SUSSES, labels);
        } else {
            return new Result(400, MessageConstant.SELECT_LABEL_FALL);
        }
    }

    /**
     * 添加标签
     *
     * @return
     */
    @PostMapping("/addLabel")
    public Result addLabel(@RequestBody Label label) {
        Integer result = service.addLabel(label);
        if (result==-1)return new Result(401, MessageConstant.ADD_LABEL_REPEAT);
        if (result == 0) return new Result(400, MessageConstant.ADD_LABEL_FALL);
        return new Result(204, MessageConstant.ADD_LABEL_SUSSES);
    }

    /**
     * 更新标签
     *
     * @return
     */
    @PutMapping("/updateLabel")
    public Result updateLabel(@RequestBody Label label) {
        Integer result = service.updateLabel(label);
        if (result==-1)return new Result(401, MessageConstant.UPDATE_LABEL_REPEAT);
        if (result == 0) return new Result(400, MessageConstant.UPDATE_LABEL_FALL);
        return new Result(204, MessageConstant.UPDATE_LABEL_SUSSES);
    }

    /**
     * 删除标签
     *
     * @return
     */
    @DeleteMapping("/deleteLabel/{id}")
    public Result deleteLabel(@PathVariable("id") Integer id) {
        Integer result = service.deleteLabel(id);
        if (result == -1) return new Result(401, MessageConstant.DELETE_RELY_FALL);
        if (result == 0) return new Result(400, MessageConstant.DELETE_LABEL_FALL);
        return new Result(204, MessageConstant.DELETE_LABEL_SUSSES);
    }

}
