package com.pde.pdes.portal.annals.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pde.pdes.portal.annals.po.AnnalsFilePO;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author jtt
 */
@Mapper
public interface AnnalsFileMapper extends BaseMapper<AnnalsFilePO> {

    /**
     * 查询所有年鉴文件
     *
     * @param queryWrapper 条件构造器
     * @return 年鉴文件列表
     */
    List<AnnalsFilePO> selectAll(@Param("ew") Wrapper<AnnalsFilePO> queryWrapper) ;

}
