package com.fatehole.blog.util;

import org.apache.shiro.util.ByteSource;

import java.util.UUID;

/**
 * @author helaos
 * @version 1.0.0
 * @date Create in 2021/03/10/15:34
 */
public class UserUtil {

    public static String md5(String username) {
        ByteSource salt = ByteSource.Util.bytes(username + UUID.randomUUID());
        return salt.toBase64();
    }
}
