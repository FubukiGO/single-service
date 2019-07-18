package com.ygg.baba.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ygg.baba.admin.model.entity.SysNoticeTemplate;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author baba
 * @since 2018-10-11
 */
public interface SysNoticeTemplateMapper extends BaseMapper<SysNoticeTemplate> {
    IPage<List<SysNoticeTemplate>> findPage(Page page, @Param("n") Map param);
}
