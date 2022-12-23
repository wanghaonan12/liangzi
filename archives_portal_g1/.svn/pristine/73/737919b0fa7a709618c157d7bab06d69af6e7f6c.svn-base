package com.pde.pdes.portal.chronicle.service;

import com.pde.pdes.portal.chronicle.dto.PdesPortalChronicleEventsFileDto;
import com.pde.pdes.portal.chronicle.po.PdesPortalChronicleEventsFile;

import java.util.List;

/**
 * @author SYKCOMPUTER
 */
public interface PdesPortalChronicleEventsFileService {
    /**
     * 新增大事件
     * @return 是否新增成功
     * @param entity 主键ID
     */
    boolean add(PdesPortalChronicleEventsFileDto entity);


    /**
     * 根据 ID 删除
     * @return 是否删除成功
     * @param id 主键ID
     */
    boolean deleteById(String id);

    /**
     * 批量删除大事件附件
     * @param ids 删除的id数组
     * @return 是否删除成功
     */
    boolean deleteByIds(List<Integer> ids);

    /**
     * 批量置顶附件
     * @param orderSeq 排序号
     * @param ids id数组
     * @return 是否置顶成功
     */
    boolean isTop(Integer orderSeq,List<Integer> ids);

    /**
     * 根据 ID 查询
     * @return 大事件附件对象
     * @param id 主键ID
     */
    PdesPortalChronicleEventsFile findById(String id);

    List<PdesPortalChronicleEventsFile> findByChronicleId(Integer id);

    /**
     * 根据 searchText 条件，模糊匹配
     * @return 返回发到大事件
     * @param searchText 实体对象封装操作类（可以为 null）
     */
    List<PdesPortalChronicleEventsFile> find(String searchText);

    /**
     * 更新大事件
     * @param events 更新的对象
     * @return 是否修改成功
     */
    boolean updateEvent(PdesPortalChronicleEventsFile events);
}
