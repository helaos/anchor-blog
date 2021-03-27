package com.fatehole.blog.service.impl;

import com.fatehole.blog.entity.Type;
import com.fatehole.blog.mapper.TypeMapper;
import com.fatehole.blog.service.TypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 类型 服务实现类
 * </p>
 *
 * @author helaos
 * @since 2021-03-09
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type> implements TypeService {

}
