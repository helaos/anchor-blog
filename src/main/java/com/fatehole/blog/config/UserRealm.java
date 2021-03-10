package com.fatehole.blog.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fatehole.blog.entity.User;
import com.fatehole.blog.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author helaos
 * @version 1.0.0
 * @date Create in 2021/03/09/20:47
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 授权
     * @param principals ？
     * @return 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("执行了 =》 doGetAuthorizationInfo");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        // 那道当前登录对象
        Subject subject = SecurityUtils.getSubject();
        // 拿到user对象
        User currentUser = (User) subject.getPrincipal();
        if (currentUser.getType() == 1) {
            authorizationInfo.addStringPermission("admin:*");
        }
        return authorizationInfo;
    }

    /**
     * 认证
     * @param token 令牌
     * @return 认证令牌
     * @throws AuthenticationException 验证错误
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行了 =》 doGetAuthenticationInfo");

        // 封装用户的登录数据
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", userToken.getUsername());
        User user = userService.getOne(wrapper);

        if (null == user) {
            // 抛出异常 UnknownAccountException
            return null;
        } else {
            // 取出盐值并编码
            ByteSource salt = ByteSource.Util.bytes(user.getSalt());
            // 密码认证，shiro帮忙做
            return new SimpleAuthenticationInfo(user, user.getPassword(), salt, this.getName());
        }

    }
}
