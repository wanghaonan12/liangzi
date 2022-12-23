package com.pde.pdes.portal.notify.service;

import com.pde.pdes.portal.notify.po.PortalNotifyFile;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
* @author jiangyiheng
* @description 针对表【pdes_portal_notify_file(通知公告附件)】的数据库操作Service
* @createDate 2022-11-30 09:59:12
*/
public interface PortalNotifyFileService extends IService<PortalNotifyFile> {

    /**
     * 添加公告的附件
     *
     * @param notifyId
     * @param file
     * @return
     */
    int addPortalNotifyFile(Integer notifyId, MultipartFile file);

    /**
     * 根据公告id获取相应的文章附件
     * @param notifyId
     * @return
     */
    List<PortalNotifyFile> selectPortalNotifyFileByNotifyId(Integer notifyId);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    boolean deletePortalNotifyFileById(Integer id);

    /**
     * 获取根据时间排名的前五个图片作为轮播图
     * @param num
     * @return
     */
    List<PortalNotifyFile> selectPortalNotifyFileByJpg(Integer num);


    /**
     * 根据ids 进行对文件附件的批量删除
     * @param ids list<notify_id>
     * @return
     */
    Integer deletePortalNotifyFileBatchById(List<Integer> ids);
}
