package com.fatehole.blog.controller;


import com.fatehole.blog.entity.User;
import com.fatehole.blog.service.UserService;
import com.fatehole.blog.vo.UserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author helaos
 * @since 2021-03-09
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody User user, RedirectAttributes attributes) {

        String passwordSource = user.getPassword();
        String salt = ByteSource.Util.bytes(user.getUsername()).toBase64();
        user.setSalt(salt);
        String password = new SimpleHash(Sha256Hash.ALGORITHM_NAME, passwordSource, salt, 1024).toBase64();
        user.setPassword(password);
        boolean flag = userService.save(user);
        if (flag) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(userVO, user);
            attributes.addFlashAttribute("user", userVO);
            return "redirect:/";
        }
        attributes.addFlashAttribute("message", "未知错误，请联系管理员！");
        return "redirect:/logon";
    }


    @GetMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "index";
    }
}
