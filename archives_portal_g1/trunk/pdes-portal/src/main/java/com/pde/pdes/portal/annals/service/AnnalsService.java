package com.pde.pdes.portal.annals.service;

import com.pde.pdes.portal.annals.dto.AnnalsDTO;
import com.pde.pdes.portal.annals.dto.AnnalsQueryCondition;
import com.pde.pdes.portal.annals.po.AnnalsPO;
import java.util.List;

/**
 * @author jtt
 */
public interface AnnalsService {


    /**
     * 分页模糊查询年鉴
     * @param query 查询条件
     * @return 分页结果
     */
    List<AnnalsPO> findByPage(AnnalsQueryCondition query);

    /**
     * 新增
     * @param annals 年鉴实体
     * @return 新增结果
     */
    Boolean insert(AnnalsDTO annals);

    /**
     * 通过ids批量删除年鉴
     * @param ids ids
     * @return 删除结果
     */
    Integer delByIds(List<Integer> ids);

    /**
     * 通过id查询年鉴
     * @param id 年鉴id
     * @return 查询结果
     */
    AnnalsPO findById(Integer id);

    /**
     * 更新年鉴
     * @param po 更新信息
     * @return 更新结果
     */
    Boolean update(AnnalsPO po);

    /**
     *批量发布年鉴
     * @param ids 多个年鉴的id
     * @return 结果
     */
    Boolean enableByIds(List<Integer> ids);

    /**
     * 批量取消发布
     * @param ids 多个年鉴的id
     * @return 结果
     */
    Boolean disableByIds(List<Integer> ids);
}
