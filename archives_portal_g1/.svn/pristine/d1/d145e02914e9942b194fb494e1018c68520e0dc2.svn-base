package com.pde.pdes.portal.photo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pde.pdes.portal.photo.po.PhotoPO;
import com.pde.pdes.portal.photo.vo.PhotoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PhotoMapper extends BaseMapper<PhotoPO> {
    /**
     * 后台相册类展示并且可以根据title模糊检索
     * @param title
     * @return
     */
    List<PhotoVO> selectPhoto(@Param("title") String title);

    /**
     * 首页轮播图查询
     * @return
     */
    List<PhotoVO> selectHomePage();
}
