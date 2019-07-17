package com.ygg.wx.admin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.ygg.wx.admin.model.entity.SysNoticeTemplate;
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
    List<SysNoticeTemplate> findPage(Pagination page, @Param("n") Map param);
}
