package com.fatehole.blog;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fatehole.blog.entity.User;
import com.fatehole.blog.service.UserService;
import com.fatehole.blog.util.UserUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AnchorBlogApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", "cifanes");
        User user = userService.getOne(wrapper);
        System.out.println(user);
    }

    @Test
    public void passwordUtilTest() {
        User cifanes = new User().setPassword("12138").setUsername("cifanes");
        // String md5 = UserUtil.md5(cifanes);
        // System.out.println(md5);
    //    4BmL4Uga1Dp4Fo5t0YjhQQ==
    }

}
