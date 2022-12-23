package com.pde.pdes.portal.annals.service;

import com.pde.pdes.portal.annals.dto.AnnalsFileDTO;
import com.pde.pdes.portal.annals.po.AnnalsFilePO;
import com.pde.pdes.portal.annals.po.AnnalsPO;

import java.util.List;

/**
 * @author jtt
 */
public interface AnnalsFileService {

    /**
     *根据id查询年鉴文档信息
     * @param id 附件id
     * @return 年鉴信息
     */
    AnnalsFilePO findById(Integer id);

    /**
     * 通过年鉴id查询年鉴列表
     * @param annals_id 年鉴id
     * @return 年鉴列表
     */
    List<AnnalsFilePO> findByAnnalsId(Integer annals_id);

    /**
     * 年鉴档案新增年鉴文件
     * @param dto dto
     * @return 新增结果
     */
    Boolean insert(AnnalsFileDTO dto);

    /**
     * 根据id更新年鉴文件信息
     *
     * @param po 更新信息
     * @return 新增结果
     */
    Boolean update(AnnalsFilePO po);

}
