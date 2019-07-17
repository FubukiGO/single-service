package com.ygg.wx.admin.model.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
@TableName("sys_notice_template")
@ApiModel("消息模版")
public class SysNoticeTemplate extends Model<SysNoticeTemplate> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
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
