package com.fatehole.blog.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author helaos
 * @version 1.0.0
 * @date Create in 2021/02/14/15:15
 */
@Controller
public class IndexController {

    @GetMapping({"/", "/index", "index.html"})
    public String index() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/archives")
    public String archives() {
        return "archives";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }

    @GetMapping("/tags")
    public String tags() {
        return "tags";
    }

    @GetMapping("/types")
    public String types() {
        return "types";
    }

    @GetMapping("/admin/blogs")
    public String blogs() {
        return "admin/blogs";
    }

    @GetMapping("/admin/input")
    public String input() {
        return "admin/input";
    }

    @GetMapping("/login")
    public String login() {
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        boolean flag = subject.isAuthenticated();
        if (flag) {
            return "forward:/";
        }
        return "admin/login";
    }

    @GetMapping("/admin/ss")
    public String test() {
        return "tags";
    }

    @GetMapping("/unauthorized")
    public String unauthorized() {
        return "about";
    }

}
