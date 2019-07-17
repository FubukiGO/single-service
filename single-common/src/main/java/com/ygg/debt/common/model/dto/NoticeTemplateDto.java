package com.ygg.debt.common.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class NoticeTemplateDto implements Serializable {

    //消息模板id
    private Integer idx;
    //消息类型
    private Integer msgType;
    //接收目标id
    private Integer userId;
    //消息变量
    private Object[] param;

    public NoticeTemplateDto(Integer idx, Integer msgType, Integer userId, Object[] param) {
        this.idx = idx;
        this.msgType = msgType;
        this.userId = userId;
        this.param = param;
    }
}
