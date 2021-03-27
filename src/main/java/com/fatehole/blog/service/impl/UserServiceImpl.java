package com.fatehole.blog.service.impl;

import com.fatehole.blog.entity.User;
import com.fatehole.blog.mapper.UserMapper;
import com.fatehole.blog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author helaos
 * @since 2021-03-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
