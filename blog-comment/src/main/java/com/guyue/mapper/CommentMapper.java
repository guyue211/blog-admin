package com.guyue.mapper;

import com.guyue.entity.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author tokyo
 * @date 2022/1/23
 */
@Repository
public interface CommentMapper {
    /**
     * 根据文章id查顶级评论
     * @param aid
     * @return
     */
    List<Comment> getCommentsByAid(@Param("aid") Integer aid);

    /**
     * 查顶级评论下子评论
     * @param parentId
     * @return
     */
    List<Comment> getParentComment(@Param("id") Integer parentId);

    /**
     * 新增评论
     * @param comment
     * @return
     */
    Integer addComment(Comment comment);

    /**
     * 更新评论
     * @param comment
     * @return
     */
    Integer updateComment(Comment comment);

    /**
     * 删除评论
     * @param id
     * @return
     */
    Integer deleteComment(Integer id);
    /**
     * 删除父评论下子评论
     * @param pid
     * @return
     */
    Integer deleteCommentByPid(Integer pid);

    Integer deleteCommentByAids(int[] aids);
}
