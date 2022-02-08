package com.guyue.controller;

import com.guyue.entity.Article;
import com.guyue.entity.Comment;
import com.guyue.service.ArticleService;
import com.guyue.service.CommentsFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.guyue.utils.MessageConstant;
import com.guyue.utils.PageInfo;
import com.guyue.utils.Result;

import java.util.HashMap;
import java.util.List;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@RestController
public class ArticleController {
    @Autowired
    private ArticleService service;
    @Autowired
    private CommentsFeignService commentsFeignService;

    /**
     * 查询全部文章 并分页
     * @param pageInfo
     * @return
     */
    @GetMapping("/admin/getArticles")
    public Result getArticles(@RequestBody PageInfo pageInfo){
        List<Article> articles = service.getArticles(pageInfo);
        if (articles==null) return new Result(400, MessageConstant.SELECT_ARTICLE_FALL);
        HashMap<Object, Object> date = new HashMap<>();
        date.put("articles",articles);
        date.put("pageInfo",pageInfo);
        return new Result(200, MessageConstant.SELECT_ARTICLE_SUSSES,date) ;
    }

    /**
     * 发布文章
     * @param article
     * @return
     */
    @PostMapping("/admin/addArticle")
    public Result addArticle(@RequestBody Article article){
        int result=service.addArticle(article);
        if(result==-1)return new Result(401,MessageConstant.ADD_RELY_FALL);
        if(result==0) return new Result(400,MessageConstant.RELEASE_ARTICLE_FALL);
        return new Result(204,MessageConstant.RELEASE_ARTICLE_SUSSES);
    }

    /**
     * 文章修改
     * @param article
     * @return
     */
    @PutMapping("/admin/updateArticle")
    public Result updateArticle(@RequestBody Article article){
        int result=service.updateArticle(article);
        if(result==0) return new Result(400,MessageConstant.UPDATE_ARTICLE_FALL);
        return new Result(204,MessageConstant.UPDATE_ARTICLE_SUSSES);
    }

    /**
     * 删除文章
     * @param ids
     * @return
     */
    @DeleteMapping("/admin/deleteArticles")
    public Result deleteArticle(@RequestBody int[] ids){
        //删除文章对应的评论
        Result result1 = commentsFeignService.deleteCommentByAid(ids);
        int result=service.deleteArticle(ids);
        if(result==-1)  return new Result(401,MessageConstant.DELETE_RELY_FALL);
        if(result==0)  return new Result(400,MessageConstant.DELETE_ARTICLE_FALL);
        return new Result(200,MessageConstant.DELETE_ARTICLE_SUSSES,result1.getData());

    }

    /**
     * 查询单文章和评论
     * @param id
     * @return
     */
    @GetMapping("/ordinary/getArticle/{id}")
    public Result getArticle(@PathVariable Integer id){

        Article article= (Article) service.getArticle(id);
        if (article==null) return new Result(400,MessageConstant.SELECT_ARTICLE_FALL);
        HashMap<Object, Object> map = new HashMap<>();
        //查文章下评论
        List<Comment> comments = commentsFeignService.getComments(id);
        if (comments.size()>0){
            map.put("comments",comments);
        }
        map.put("article",article);
        return new Result(200,MessageConstant.SELECT_ARTICLE_SUSSES,map);
    }

    /**
     * 删除类别 将依赖文章cid设置为0
     * @param cid
     * @return
     */
    @PutMapping("/admin/updateArticleByCid")
    public Result updateArticleByCid(@RequestParam("id") Integer cid){
        Integer result=service.updateArticleByCid(cid);
        if(result==0) return new Result(400,MessageConstant.UPDATE_ARTICLE_FALL);
        return new Result(204,MessageConstant.UPDATE_ARTICLE_SUSSES);
    }

}
