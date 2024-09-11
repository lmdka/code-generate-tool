package com.lmdka.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 字典表
 * </p>
 *
 * @author lmdka
 * @since 2024-09-11
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_dict")
public class Dict {

    /**
     * 主键ID
     */
    @TableId("id")
    private String id;

    /**
     * 状态
     */
    @TableField("status")
    private String status;

    /**
     * 删除标识
     */
    @TableField("del_flag")
    @TableLogic
    private String delFlag;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 排序
     */
    @TableField("sort")
    private Long sort;

    /**
     * 创建人
     */
    @TableField("create_by")
    private String createBy;

    /**
     * 更新人
     */
    @TableField("update_by")
    private String updateBy;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 字典名称
     */
    @TableField("name")
    private String name;

    /**
     * 字典类型
     */
    @TableField("type")
    private String type;
}
