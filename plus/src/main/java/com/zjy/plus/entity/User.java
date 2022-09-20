package com.zjy.plus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
public class User {
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;//mybatis-plus默认的主键策略是:ASSIG_ID 使用了雪花算法 还可以用自增AUTO
    private String name;
    private Integer age;
    private String email;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version
    @TableField(fill = FieldFill.INSERT)
    private Integer version;
    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleted;
}
