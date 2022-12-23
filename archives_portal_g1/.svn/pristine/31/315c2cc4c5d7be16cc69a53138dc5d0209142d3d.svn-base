package com.pde.pdes.portal.annals.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pde.pdes.portal.annals.dto.AnnalsFileDTO;
import com.pde.pdes.portal.annals.mapper.AnnalsFileMapper;
import com.pde.pdes.portal.annals.po.AnnalsFilePO;
import com.pde.pdes.portal.annals.service.AnnalsFileService;
import com.pde.pdes.portal.annals.service.AnnalsService;
import io.jsonwebtoken.lang.Assert;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.pde.pdes.portal.video.utils.MyBeanUtilsHelper.getNullPropertyNames;


/**
 * @author jtt
 */
@Service
public class AnnalsFileServiceImpl implements AnnalsFileService {

    @Resource
    private AnnalsFileMapper annalsFileMapper;

    @Override
    public AnnalsFilePO findById(Integer id) {
        Assert.notNull(id,"id不能为空");
        return annalsFileMapper.selectById(id);
    }

    @Override
    public List<AnnalsFilePO> findByAnnalsId(Integer annals_id) {
        Assert.notNull(annals_id,"年鉴ID不能为空");
        return annalsFileMapper.selectAll(new QueryWrapper<AnnalsFilePO>().eq("annals_id",annals_id));
    }

    @Override
    public Boolean insert(AnnalsFileDTO dto) {
        Assert.notNull(dto,"保存对象不能为空");
        int insert =annalsFileMapper.insert(AnnalsFilePO.builder()
                .annals_id(dto.getAnnals_id())
                .file_name(dto.getFile_name())
                .flie_size(dto.getFile_size())
                .file_path(dto.getFile_path())
                .order_seq(dto.getOrder_seq())
                .create_time(dto.getCreate_time())
                .build());
        return insert > 0;
    }

    @Override
    public Boolean update(AnnalsFilePO po) {
        AnnalsFilePO newPo = annalsFileMapper.selectById(po.getId());
        org.springframework.util.Assert.notNull(po, "更新对象不能为空.");
        org.springframework.util.Assert.notNull(newPo, "id不存在");
        BeanUtils.copyProperties(po, newPo, getNullPropertyNames(po));
        int i = annalsFileMapper.updateById(newPo);
        return i > 0;
    }
}
