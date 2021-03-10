package com.fatehole.blog.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author helaos
 * @version 1.0.0
 * @date Create in 2021/03/09/20:17
 */
@Configuration
public class ShiroConfig {

    /**
     * 配置自定义Realm
     * @return 注册Realm
     */
    @Bean
    public UserRealm userRealm(HashedCredentialsMatcher credentialsMatcher) {
        UserRealm userRealm = new UserRealm();
        // 配置使用哈希密码匹配
        userRealm.setCredentialsMatcher(credentialsMatcher);
        return userRealm;
    }

    @Bean
    public SessionsSecurityManager securityManager(UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * ShiroDialect，为了在thymeleaf里使用shiro的标签的bean
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
    /**
     * anon: 无需认证就可访问
     * authc: 必须认证了才能访问
     * user: 必须用于 记住我 功能才能用
     * perms: 用于对某个资源的权限才能访问
     * role: 拥有某个角色权限才能访问
     */

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        chainDefinition.addPathDefinition("/admin/**", "perms[admin:*]");
        chainDefinition.addPathDefinition("/login", "anon");
        chainDefinition.addPathDefinition("/**", "anon");
        chainDefinition.addPathDefinition("/logout", "logout");
        return chainDefinition;
    }


    @Bean
    public HashedCredentialsMatcher credentialsMatcher() {

        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        // 散列算法，这里使用更安全的sha256算法
        credentialsMatcher.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);
        // 数据库存储的密码字段使用HEX还是BASE64方式加密
        credentialsMatcher.setStoredCredentialsHexEncoded(false);
        // 散列迭代次数
        credentialsMatcher.setHashIterations(1024);
        return credentialsMatcher;
    }
}
