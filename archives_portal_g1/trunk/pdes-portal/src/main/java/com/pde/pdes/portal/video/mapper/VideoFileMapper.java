package com.pde.pdes.portal.video.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pde.pdes.portal.video.po.VideoFilePO;
import com.pde.pdes.portal.video.vo.portal.PortalFileVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: mth
 * @date: 2022/12/1
 * @description: 视频文件 Mapper文件
 */
@Mapper
public interface VideoFileMapper extends BaseMapper<VideoFilePO> {

    /**
     * 查询所有视频文件
     *
     * @param queryWrapper 条件构造器
     * @return 视频文件列表
     */
    List<VideoFilePO> selectAll(@Param("ew") Wrapper<VideoFilePO> queryWrapper);

    /**
     * 根据视频专辑id查询视频文件
     *
     * @param id 视频专辑id
     * @return 视频文件
     */
    List<PortalFileVO> selectFileByVideoId(@Param("id") Integer id);

    /**
     * 根据视频文件id查询封面
     *
     * @param id 视频文件id
     * @return 封面地址
     */
    String selectFrontPathByFileId(@Param("id") Integer id);

}
