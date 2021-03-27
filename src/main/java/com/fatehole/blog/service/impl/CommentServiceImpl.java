package com.fatehole.blog.service.impl;

import com.fatehole.blog.entity.Comment;
import com.fatehole.blog.mapper.CommentMapper;
import com.fatehole.blog.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author helaos
 * @since 2021-03-09
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
