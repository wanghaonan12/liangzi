package com.pde.pdes.portal.archive.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pde.pdes.portal.archive.dao.ArchiveDao;
import com.pde.pdes.portal.archive.po.ArchivePo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArchiveMapper extends BaseMapper<ArchivePo> {
    ArchiveDao SelectByJoinId(Integer id);

    Integer myInsert(ArchivePo archivePo);
}