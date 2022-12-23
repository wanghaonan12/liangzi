package com.pde.pdes.portal.chronicle.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pde.pdes.portal.chronicle.dto.PdesPortalChronicleEventsDto;
import com.pde.pdes.portal.chronicle.mapper.PdesPortalChronicleEventsMapper;
import com.pde.pdes.portal.chronicle.po.PdesPortalChronicleEvents;
import com.pde.pdes.portal.chronicle.service.PdesPortalChronicleEventsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author SYKCOMPUTER
 */
@Service

public class PdesPortalChronicleEventsServiceImpl extends ServiceImpl<PdesPortalChronicleEventsMapper, PdesPortalChronicleEvents> implements PdesPortalChronicleEventsService {
    @Resource
    PdesPortalChronicleEventsMapper pdesPortalChronicleEventsMapper;
    @Override
    public boolean add(PdesPortalChronicleEventsDto entity) {
        Assert.notNull(entity, "保存对象不能为空.");
        return save(PdesPortalChronicleEvents
                .builder()
                .content(entity.getContent())
                .contentAbstract(entity.getContentAbstract())
                .title(entity.getTitle())
                .enablePublish(entity.getEnablePublish())
                .createTime(new Date())
                .modifiedTime(new Date())
                .build());
    }

    @Override
    public boolean deleteById(String id) {
        Assert.hasText(id, "删除主键不能为空.");
        return removeById(id);
    }

    @Override
    public boolean deleteByIds(List<Integer> ids) {
        Assert.hasText(ids.toString(), "删除主键不能为空.");
        return pdesPortalChronicleEventsMapper.deleteChronicleByIds(ids);
    }

    @Override
    public boolean isPublished(Boolean isPublished,List<Integer> ids) {
        Assert.hasText(ids.toString(), "发布文章的id不为空");
        return pdesPortalChronicleEventsMapper.publishByIds(isPublished,ids);
    }

    @Override
    public PdesPortalChronicleEvents findById(String id) {
        Assert.hasText(id, "查询条件不能为空.");
        return getById(id);
    }

    @Override
    public List<PdesPortalChronicleEvents> find(String searchText) {
        if (StringUtils.isEmpty(searchText)) {
            return list();
        } else {
            return list(Wrappers.lambdaQuery(PdesPortalChronicleEvents.class).like(PdesPortalChronicleEvents::getTitle, searchText).or()
                    .like(PdesPortalChronicleEvents::getContent, searchText).or().like(PdesPortalChronicleEvents::getEnablePublish, searchText).or().like(PdesPortalChronicleEvents::getContentAbstract, searchText));
        }
    }

    @Override
    public boolean updateEvent(PdesPortalChronicleEvents events) {
        PdesPortalChronicleEvents pde = PdesPortalChronicleEvents.builder()
                .id(events.getId())
                .content(events.getContent())
                .enablePublish(events.getEnablePublish())
                .title(events.getTitle())
                .contentAbstract(events.getContentAbstract())
                .modifiedTime(new Date())
                .build();
        return updateById(pde);
    }
}



