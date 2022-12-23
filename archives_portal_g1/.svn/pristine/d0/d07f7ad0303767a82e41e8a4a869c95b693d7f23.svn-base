package com.pde.pdes.portal.archive.service.Impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pde.p10c.auth.JwtTokenManager;
import com.pde.pdes.portal.archive.dao.ArchiveUpdateDao;
import com.pde.pdes.portal.archive.mapper.ArchiveMapper;
import com.pde.pdes.portal.archive.mapper.ArchiveFileMapper;
import com.pde.pdes.portal.archive.po.ArchivePo;
import com.pde.pdes.portal.archive.service.ArchiveService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.*;

/**
 * @author xiaozp
 * @date 2022-12-21 19：00
 */

@Service
public class ArchiveServiceImpl extends ServiceImpl<ArchiveMapper, ArchivePo> implements ArchiveService {

    @Resource
    public ArchiveFileMapper archiveFileMapper;

    @Resource
    public ArchiveMapper archive;

    /**
     * 获取token，再postman里面测试请求头需要携带Banner token
     * @param args
     */
    public static void main(String[] args) {
        JwtTokenManager jtm = new JwtTokenManager();
        String token = jtm.createToken("xzp");
        System.out.println(token);
    }

    /**
     * 前端根据是否发布查询
     * @param searchText
     * @return List<ArchivePo>
     */
    @Override
    public List<ArchivePo> selectAll(String searchText) {
        if (StringUtils.isEmpty(searchText)) {
            return list(Wrappers.lambdaQuery(ArchivePo.class).eq(ArchivePo::getEnablePublish, 1).or());
        }
        else {
            return list(Wrappers.lambdaQuery(ArchivePo.class).like(ArchivePo::getTitle, searchText).eq(ArchivePo::getEnablePublish, 1).or());
        }
    }

    /**
     * 后端查询全部
     * @param searchText
     * @return List<ArchivePo>
     */
    @Override
    public List<ArchivePo> selectAll2(String searchText) {
        if (StringUtils.isEmpty(searchText)) {
            return list(Wrappers.lambdaQuery(ArchivePo.class).or());
        }
        else {
            return list(Wrappers.lambdaQuery(ArchivePo.class).like(ArchivePo::getTitle, searchText).or());
        }
    }

    /**
     * 根据id查询
     * @param id
     * @return ArchivePo
     */
    @Override
    public ArchivePo selectById(Integer id) {
        return archive.selectById(id);
    }

    /**
     * 修改开放档案
     * @param archiveAddDao
     * @return Integer
     */
    @Override
    public Integer update(ArchiveUpdateDao archiveAddDao) {
        UpdateWrapper<ArchivePo> wrapper = Wrappers.update();
        wrapper.lambda()
                .set(ArchivePo::getSecurityClass, archiveAddDao.getSecurityClass())
                .set(ArchivePo::getEnablePublish, archiveAddDao.getEnablePublish())
                .set(ArchivePo::getModifiedTime, new Date())
                .eq(ArchivePo::getId, archiveAddDao.getId());
        return archive.update(null,wrapper);
    }

    /**
     * 删除单个
     * @param id
     * @return Boolean
     */
    @Override
    public Boolean del(Integer id) {
        if(archive.deleteById(id)==1){
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除多个
     * @param list
     * @return Integer
     */
    @Override
    public Integer delList(Integer[] list) {
        return archive.deleteBatchIds(Arrays.asList(list));
    }

    /**
     * 新增开放档案
     * @param archivePo
     * @return Integer
     */
    @Override
    public Integer add(ArchivePo archivePo) {
        return archive.myInsert(archivePo);
    }

}
