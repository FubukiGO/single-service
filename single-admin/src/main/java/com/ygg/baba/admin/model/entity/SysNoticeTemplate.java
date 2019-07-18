package com.ygg.baba.admin.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author baba
 * @since 2018-10-11
 */
@Data
@ApiModel("消息模版")
@TableName("sys_notice_template")
@EqualsAndHashCode(callSuper = false)
public class SysNoticeTemplate extends Model<SysNoticeTemplate> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 模版名称
     */
    @ApiModelProperty("模版名称")
    private String name;
    /**
     * 消息类型1短信 2系统推送
     */
    @ApiModelProperty("消息类型1短信 2系统推送")
    private Integer type;
    /**
     * 标示[20]
     */
    @ApiModelProperty("标示[20]")
    private String sign;
    /**
     * 标题[20]
     */
    @ApiModelProperty("标题[20]")
    private String title;
    /**
     * 状态:1启用 2关闭
     */
    @ApiModelProperty("状态:1启用 2关闭")
    private Integer status;
    /**
     * 模版内容[255]
     */
    @ApiModelProperty("模版内容[255]")
    private String content;
    /**
     * 备注[255]
     */
    @ApiModelProperty("备注[255]")
    private String remark;
    @TableField("del_flag")
    private String delFlag;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField("modified_time")
    private Date modifiedTime;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SysNoticeTemplate{" +
                ", id=" + id +
                ", type=" + type +
                ", sign=" + sign +
                ", title=" + title +
                ", status=" + status +
                ", content=" + content +
                ", remark=" + remark +
                ", delFlag=" + delFlag +
                "}";
    }
}
