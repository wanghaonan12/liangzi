package com.pde.pdes.portal.video.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pde.pdes.portal.video.po.VideoFileFrontPO;
import com.pde.pdes.portal.video.vo.VideoFileFrontListVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: mth
 * @date: 2022/12/6
 * @description: 视频文件封面 Mapper文件
 */
@Mapper
public interface VideoFileFrontMapper extends BaseMapper<VideoFileFrontPO> {
    /**
     * 查询所有视频文件封面
     *
     * @param queryWrapper 条件构造器
     * @return 视频文件封面列表
     */
    List<VideoFileFrontPO> selectAll(@Param("ew") Wrapper<VideoFileFrontPO> queryWrapper);

    /**
     * 根据视频文件id查询所有视频封面
     *
     * @param id 视频文件id
     * @return 视频封面
     */
    List<VideoFileFrontListVO> selectByVideoFileId(@Param("id") Integer id);
}
