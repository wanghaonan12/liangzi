package com.pde.pdes.portal.photo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pde.pdes.portal.photo.po.PhotoFilePO;
import com.pde.pdes.portal.photo.vo.PhotoFileVO;
import com.pde.pdes.portal.photo.vo.PhotoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PhotoFileMapper extends BaseMapper<PhotoFilePO> {
    List<PhotoFileVO> selectAllFiles(Integer id);
}
