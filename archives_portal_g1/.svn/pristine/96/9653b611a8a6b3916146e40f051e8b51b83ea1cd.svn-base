package com.pde.pdes.portal.video.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pde.pdes.portal.video.po.VideoPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: mth
 * @date: 2022/12/1
 * @description: 视频档案 Mapper
 */
@Mapper
public interface VideoMapper extends BaseMapper<VideoPO> {

    /**
     * 查询所有视频档案
     *
     * @param queryWrapper 条件构造器
     * @return 视频档案列表
     */
    List<VideoPO> selectAll(@Param("ew") Wrapper<VideoPO> queryWrapper);

    /**
     * 查询视频专辑封面
     *
     * @param id 视频专辑id
     * @return 视频专辑封面
     */
    String selectFrontByVideoId(@Param("id") Integer id);

}
