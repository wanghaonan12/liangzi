package com.pde.pdes.portal.chronicle.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pde.pdes.portal.chronicle.po.PdesPortalChronicleEvents;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @author SYKCOMPUTER
 */
@Mapper
public interface PdesPortalChronicleEventsMapper extends BaseMapper<PdesPortalChronicleEvents>{

    /**
     * 批量发布接口层
     * @param isPublished 发布状态
     * @param ids 待发布的事件数组
     * @return 是否发布
     */
    boolean publishByIds(Boolean isPublished, List<Integer> ids);

    /**
     * 删除大事记将相关联大事记附件同时删除
     * @param ids
     * @return
     */
    boolean deleteChronicleByIds(List<Integer> ids);




}
