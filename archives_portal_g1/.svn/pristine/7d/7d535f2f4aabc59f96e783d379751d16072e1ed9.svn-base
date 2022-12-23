package com.pde.pdes.portal.annals.mapper;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pde.pdes.portal.annals.po.AnnalsFilePO;
import com.pde.pdes.portal.annals.po.AnnalsPO;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author jtt
 */
@Mapper
public interface AnnalsMapper extends BaseMapper<AnnalsPO> {


    /**
     * 查询所有视频档案
     *
     * @param queryWrapper 条件构造器
     * @return 视频档案列表
     */
    List<AnnalsPO> selectAll(@Param("ew") Wrapper<AnnalsPO> queryWrapper) ;

}
