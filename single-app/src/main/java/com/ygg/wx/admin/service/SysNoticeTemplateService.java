package com.ygg.wx.admin.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ygg.wx.admin.model.entity.SysNoticeTemplate;

import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author baba
 * @since 2018-10-11
 */
public interface SysNoticeTemplateService extends IService<SysNoticeTemplate> {

    IPage findPage(Page page, Map param);

    SysNoticeTemplate findTemplateDetail(Integer id);

    String[] arrayFomat(Object[] param);

    /**
     * 发送站内信
     *
     * @param idx     模版id
     * @param msgType 模版消息类型
     * @param userId  接收人id
     * @param param   变量
     */
    void sendNotice(Integer idx, Integer msgType, Integer userId, Object... param);

    void sendNoticeAsSms(Integer idx, Integer userId, Object... param);
}
