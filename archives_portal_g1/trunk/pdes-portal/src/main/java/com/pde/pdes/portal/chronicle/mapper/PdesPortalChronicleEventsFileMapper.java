package com.pde.pdes.portal.chronicle.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pde.pdes.portal.chronicle.po.PdesPortalChronicleEventsFile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

/**
 * @author SYKCOMPUTER
 */
@Mapper
public interface PdesPortalChronicleEventsFileMapper extends BaseMapper<PdesPortalChronicleEventsFile>{
    /**
     * 根据大事记ID来查询附件信息
     * @param id
     * @return 附件列表
     */
    @Select("select p1.id,p1.chronicle_events_id chronicleEventsId,p1.file_name fileName,p1.file_size fileSize,p1.file_suffix fileSuffix,p1.file_path filePath,p1.memo memo,p1.order_seq orderSeq,p1.create_time createTime" +
            " FROM pdes_portal_chronicle_events_file as p1 " +
            "WHERE p1.chronicle_events_id = #{id} ")
    List<PdesPortalChronicleEventsFile>  getChronicleFileById(Integer id);

    /**
     * 批量置顶大事件附件接口层
     * @param orderSeq 置顶状态
     * @param ids 待置顶的事件数组
     * @return 是否成功置顶
     */
    boolean topChronicleFile(Integer orderSeq , List<Integer> ids);

}
