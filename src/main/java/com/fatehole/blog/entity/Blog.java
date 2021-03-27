package com.fatehole.blog.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 博客
 * </p>
 *
 * @author helaos
 * @since 2021-03-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_blog")
@ApiModel(value="Blog对象", description="博客")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "博客ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "标题")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "博文")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "首页图片")
    @TableField("first_picture")
    private String firstPicture;

    @ApiModelProperty(value = "标记")
    @TableField("flag")
    private String flag;

    @ApiModelProperty(value = "浏览数")
    @TableField("views")
    private Integer views;

    @ApiModelProperty(value = "是否赞赏")
    @TableField("appreciation")
    private Boolean appreciation;

    @ApiModelProperty(value = "是否转载声明")
    @TableField("share_statement")
    private Boolean shareStatement;

    @ApiModelProperty(value = "是否评论")
    @TableField("commentable")
    private Boolean commentable;

    @ApiModelProperty(value = "是否发布")
    @TableField("published")
    private Boolean published;

    @ApiModelProperty(value = "是否推荐")
    @TableField("recommend")
    private Boolean recommend;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "修改时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "类型ID")
    @TableField("type_id")
    private Long typeId;

    @ApiModelProperty(value = "用户ID")
    @TableField("user_id")
    private Long userId;

    @ApiModelProperty(value = "评论数")
    @TableField("comment_count")
    private Integer commentCount;


}
