package com.pde.pdes.portal.notify.service;

import com.pde.pdes.portal.notify.po.PortalNotify;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author jiangyiheng
* @description 针对表【pdes_portal_notify(通知公告)】的数据库操作Service
* @createDate 2022-11-30 09:59:12
*/
public interface PortalNotifyService extends IService<PortalNotify> {
    /**
     * 模糊分页查询查询
     * @param searchText
     * @return
     */
    List<PortalNotify> find(String searchText);

    /**
     * 模糊分页查询查询
     * @param searchText
     * @return
     */
    List<PortalNotify> findDisablePublish(String searchText);


    /**
     * 根据 ID 删除公告
     * @param id
     * @return
     */
    boolean deleteById(String id);

    /**
     * 根据id去查找是否存在记录
     * @param id
     * @return
     */
    PortalNotify selectById(Integer id);

    /**
     * 进行对文章的新增
     * @param portalNotify
     * @return
     */
    boolean add(PortalNotify portalNotify);

    /**
     * 进行对公告文章的更新修改
     * @param portalNotify
     * @return
     */
    boolean updatePortalNotify(PortalNotify portalNotify);

    /**
     * 批量删除公告
     * @param idList
     * @return
     */
    Integer deleteBatchByIds(List<Integer> idList);

}
