package com.ygg.baba.app.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ygg.baba.app.mapper.SysNoticeTemplateMapper;
import com.ygg.baba.app.model.entity.SysNoticeTemplate;
import com.ygg.baba.app.service.SysNoticeTemplateService;
import com.ygg.baba.common.constants.MqQueueConstant;
import com.ygg.baba.common.model.dto.NoticeTemplateDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author baba
 * @since 2018-10-11
 */
@Slf4j
@Service
@AllArgsConstructor
public class SysNoticeTemplateServiceImpl extends ServiceImpl<SysNoticeTemplateMapper, SysNoticeTemplate> implements SysNoticeTemplateService {

    private final FastDateFormat fdf = FastDateFormat.getInstance("yyyy年MM月dd日 HH时mm分");

    private final DecimalFormat df = new DecimalFormat("0.00");

    private final RabbitTemplate rabbitTemplate;

    @Override
    public IPage findPage(Page page, Map param) {
        return baseMapper.findPage(page, param);
    }

    @Override
    public String[] arrayFomat(Object[] tar) {
        if (tar.length > 0) {
            String[] res = new String[tar.length];

            for (int i = 0; i < tar.length; i++) {
                String foo;
                if (tar[i] instanceof BigDecimal) {
                    foo = df.format(tar[i]);
                } else if (tar[i] instanceof Date) {
                    foo = fdf.format(tar[i]);
                } else {
                    foo = String.valueOf(tar[i]);
                }
                res[i] = foo;
            }
            return res;
        }
        return new String[]{};
    }

    @Override
    @Cacheable(value = "notice_template", key = "'template_' + #id")
    public SysNoticeTemplate findTemplateDetail(Integer id) {
        return this.getOne(Wrappers.<SysNoticeTemplate>query().eq("del_flag", "0").eq("id", id));
    }

    /**
     * 发送站内信
     *
     * @param idx     模版id
     * @param msgType 模版消息类型
     * @param userId  接收人id
     * @param param   变量
     */
    @Override
    public void sendNotice(Integer idx, Integer msgType, Integer userId, Object... param) {
        rabbitTemplate.convertAndSend(MqQueueConstant.NOTICE_PROCESSOR, new NoticeTemplateDto(idx, msgType, userId, param));
    }

    @Override
    public void sendNoticeAsSms(Integer idx, Integer userId, Object... param) {

    }
}
