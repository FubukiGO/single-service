package com.ygg.baba.common.model.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author akhan
 * @description 消息推送pojo
 * @date 11:54 2018-12-25
 */
@Data
public class PushMsgDto implements Serializable {
    //平台标示 1 web 2 app 0全端推送
    private Integer platform;
    private String msg;
    private String title;
    private String contentType;
    private Integer userId;
    private String extra;
    //跳转链接(如果有
    private String href;

    public PushMsgDto() {

    }

    public PushMsgDto(Integer platform, String msg, Integer userId) {
        this.platform = platform;
        this.msg = msg;
        this.userId = userId;
    }

    public PushMsgDto(Integer platform, String msg, Integer userId, String href) {
        this.platform = platform;
        this.msg = msg;
        this.userId = userId;
        this.href = href;
    }

    public PushMsgDto(Integer platform, String msg, String title, String contentType, Integer userId, String extra, String href) {
        this.platform = platform;
        this.msg = msg;
        this.title = title;
        this.contentType = contentType;
        this.userId = userId;
        this.extra = extra;
        this.href = href;
    }

    public static PushMsgDto.Builder newBuilder() {
        return new PushMsgDto.Builder();
    }

    public static class Builder {
        private Integer platform = null;
        private String msg = null;
        private Integer userId = null;
        private String extra = null;
        private String title = null;
        private String contentType = null;
        //跳转链接(如果有
        private String href = null;

        public Builder() {
        }

        public PushMsgDto.Builder setPlatform(Integer platform) {
            this.platform = platform;
            return this;
        }

        public PushMsgDto.Builder setMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public PushMsgDto.Builder setUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public PushMsgDto.Builder setExtras(String extra) {
            this.extra = extra;
            return this;
        }

        public PushMsgDto.Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public PushMsgDto.Builder setContentType(String contentType) {
            this.contentType = contentType;
            return this;
        }

        public PushMsgDto.Builder setHref(String href) {
            this.href = href;
            return this;
        }

        public PushMsgDto bulid() {
            return new PushMsgDto(platform, msg, title, contentType, userId, extra, href);
        }
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PushMsgDto{");
        sb.append("platform=").append(platform);
        sb.append(", msg='").append(msg).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append(", contentType='").append(contentType).append('\'');
        sb.append(", userId=").append(userId);
        sb.append(", extra='").append(extra).append('\'');
        sb.append(", href='").append(href).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
