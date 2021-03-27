package com.fatehole.blog.service.impl;

import com.fatehole.blog.entity.Tag;
import com.fatehole.blog.mapper.TagMapper;
import com.fatehole.blog.service.TagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 标签 服务实现类
 * </p>
 *
 * @author helaos
 * @since 2021-03-09
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {

}
