package com.fqh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@TableName(value = "sys_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String userName;
    private String nickName;
    private String password;
    /**
     * 账号状态 0-正常 1-停用
     */
    private String status;
    private String email;
    private String phoneNumber;
    /**
     * 性别 0-男 1-女 2-未知
     */
    private String sex;
    private String avatar;
    /**
     * 用户类型 0-管理员 1-普通用户
     */
    private String userType;
    private Long createBy;
    private Date createTime;
    private Long updateBy;
    private Date updateTime;
    /**
     * 删除标记 0-未删除 1-已删除
     */
    private Integer delFlag;
}
