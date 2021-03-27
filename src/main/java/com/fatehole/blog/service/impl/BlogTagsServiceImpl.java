package com.fatehole.blog.service.impl;

import com.fatehole.blog.entity.BlogTags;
import com.fatehole.blog.mapper.BlogTagsMapper;
import com.fatehole.blog.service.BlogTagsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 博客与标签关联 服务实现类
 * </p>
 *
 * @author helaos
 * @since 2021-03-09
 */
@Service
public class BlogTagsServiceImpl extends ServiceImpl<BlogTagsMapper, BlogTags> implements BlogTagsService {

}
