package com.pde.pdes.portal.archive.service;

import com.pde.pdes.portal.archive.dao.ArchiveDao;
import com.pde.pdes.portal.archive.dao.ArchiveFileAddDao;
import com.pde.pdes.portal.archive.dao.ArchiveFileUpdateDao;
import com.pde.pdes.portal.archive.dao.ArchiveUpdateDao;
import com.pde.pdes.portal.archive.po.ArchiveFilePo;
import com.pde.pdes.portal.archive.po.ArchivePo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xiaozp
 * @date 2022-12-21 19：00
 */
public interface ArchiveFlieService {
    List<ArchiveFilePo> selectAll(String searchText);

    ArchiveFilePo selectById(@Param("id") Integer id);

    Integer update(ArchiveFileUpdateDao archiveFileUpdateDao);

    Boolean del(Integer id);

    Integer delList(Integer[] list);

    Integer add(ArchiveFileAddDao archiveFileAddDao);
}
