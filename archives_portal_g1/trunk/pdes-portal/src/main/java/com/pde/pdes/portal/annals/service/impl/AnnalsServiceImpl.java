package com.pde.pdes.portal.annals.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.util.StringUtil;
import com.mysql.cj.util.StringUtils;
import com.pde.pdes.portal.annals.dto.AnnalsDTO;
import com.pde.pdes.portal.annals.dto.AnnalsQueryCondition;
import com.pde.pdes.portal.annals.mapper.AnnalsMapper;
import com.pde.pdes.portal.annals.po.AnnalsPO;
import com.pde.pdes.portal.annals.service.AnnalsService;
import io.jsonwebtoken.lang.Assert;
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
public class AnnalsServiceImpl implements AnnalsService {

    @Resource
    private AnnalsMapper annalsMapper;

    @Override
    public List<AnnalsPO> findByPage(AnnalsQueryCondition query) {
        QueryWrapper<AnnalsPO> queryWrapper = new QueryWrapper<>();
        String searchText = query.getSearchText();
        if (!(StringUtils.isNullOrEmpty(searchText))) {
            queryWrapper.like("a.title", searchText)
                    .or().like("a.content", searchText)
                    .or().like("a.content_abstract",searchText)
                    .or().like("f.file_name", searchText);
        }
        queryWrapper.orderByDesc("creat_time");
        return annalsMapper.selectAll(queryWrapper);
    }

    @Override
    public Boolean insert(AnnalsDTO annals) {
        Assert.notNull(annals,"保存对象不能为空");
        int insert = annalsMapper.insert(AnnalsPO.builder()
                        .title(annals.getTitle())
                        .content(annals.getContent())
                        .content_abstract(annals.getContent())
                .build());
        return insert > 0;
    }

    @Override
    public Integer delByIds(List<Integer> ids) {

        return annalsMapper.deleteBatchIds(ids);
    }

    @Override
    public AnnalsPO findById(Integer id) {
        return annalsMapper.selectById(id);
    }

    @Override
    public Boolean update(AnnalsPO po) {
        AnnalsPO newPo = annalsMapper.selectById(po.getId());
        Assert.notNull(po,"更新对象不能为空");
        Assert.notNull(newPo,"id不存在");
        BeanUtils.copyProperties(po, newPo, getNullPropertyNames(po));
        int i =annalsMapper.updateById(newPo);
        return i > 0;
    }

    @Override
    public Boolean enableByIds(List<Integer> ids) {
        ids.forEach(id ->{
            AnnalsPO annalsPO = annalsMapper.selectById(id);
            Assert.notNull(annalsPO,"指定id不存在");
            AnnalsPO annals= AnnalsPO.builder().id(id).enable_publish(1).build();
            System.out.println(annals);
            int i = annalsMapper.updateById(annals);
        });
        return true;
    }

    @Override
    public Boolean disableByIds(List<Integer> ids) {
        ids.forEach(id ->{
            AnnalsPO annalsPO = annalsMapper.selectById(id);
            Assert.notNull(annalsPO,"指定id不存在");
            AnnalsPO annals= AnnalsPO.builder().id(id).enable_publish(0).build();
            System.out.println(annals);
            int i = annalsMapper.updateById(annals);
        });
        return true;
    }
}
