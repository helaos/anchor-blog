package com.fatehole.blog.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author helaos
 * @version 1.0.0
 * @date Create in 2021/03/09/23:30
 */
@Data
@ApiModel(value="UserVO对象", description="用户登录返回数据")
public class UserVO {

    @ApiModelProperty(value = "用户ID")
    private Long id;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "头像地址")
    private String avatar;

    @ApiModelProperty(value = "用户类型")
    private Integer type;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
