package com.fatehole.blog.controller.admin;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author helaos
 * @version 1.0.0
 * @date Create in 2021/03/09/20:43
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @PostMapping("/verify")
    public String verifyLogin(String username, String password, RedirectAttributes attributes) {
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户的登陆数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行登录的方法，如果没有异常就说明ok
        try {
            subject.login(token);
            return "redirect:/";
        } catch (UnknownAccountException uae) {
            // 用户名错误
            uae.printStackTrace();
            attributes.addFlashAttribute("message", "用户名错误");
            return "redirect:/login";
        } catch (IncorrectCredentialsException ice) {
            // 密码错误
            ice.printStackTrace();
            attributes.addFlashAttribute("message", "密码错误");
            return "redirect:/login";
        } catch (LockedAccountException lae) {
            // 账户锁定
            lae.printStackTrace();
            attributes.addFlashAttribute("message", "账户锁定，请联系管理员解锁！");
            return "redirect:/login";
        }
    }
}
