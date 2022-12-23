package com.pde.pdes.portal.archive.service.Impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pde.pdes.portal.archive.dao.ArchiveFileAddDao;
import com.pde.pdes.portal.archive.dao.ArchiveFileUpdateDao;
import com.pde.pdes.portal.archive.mapper.ArchiveMapper;
import com.pde.pdes.portal.archive.mapper.ArchiveFileMapper;
import com.pde.pdes.portal.archive.po.ArchiveFilePo;
import com.pde.pdes.portal.archive.service.ArchiveFlieService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author xiaozp
 * @date 2022-12-21 19：00
 */

@Service
public class ArchiveFileServiceImpl extends ServiceImpl<ArchiveFileMapper, ArchiveFilePo> implements ArchiveFlieService {
    @Resource
    public ArchiveFileMapper archiveFileMapper;

    @Resource
    public ArchiveMapper archive;

    /**
     * 查询文件列表
     * @param searchText
     * @return List<ArchiveFilePo>
     */
    @Override
    public List<ArchiveFilePo> selectAll(String searchText) {
        if (StringUtils.isEmpty(searchText)) {
            return list();
        }
        else {
            return list(Wrappers.lambdaQuery(ArchiveFilePo.class).like(ArchiveFilePo::getFileName, searchText).or());
        }
    }

    /**
     * 通过id查询
     * @param id
     * @return ArchiveFilePo
     */
    @Override
    public ArchiveFilePo selectById(Integer id) {
        return archiveFileMapper.selectById(id);
    }

    /**
     * 更新文件
     * @param archiveFileUpdateDao
     * @return Integer
     */
    @Override
    public Integer update(ArchiveFileUpdateDao archiveFileUpdateDao) {
        UpdateWrapper<ArchiveFilePo> wrapper = Wrappers.update();
        wrapper.lambda()
                .set(ArchiveFilePo::getFilePath, archiveFileUpdateDao.getFilePath())
                .set(ArchiveFilePo::getFileSize, archiveFileUpdateDao.getFileSize())
                .set(ArchiveFilePo::getFileName, archiveFileUpdateDao.getFileName())
                .set(ArchiveFilePo::getCreateTime, new Date())
                .eq(ArchiveFilePo::getArchiveId, archiveFileUpdateDao.getArchiveId());
        return archiveFileMapper.update(null,wrapper);
    }

    /**
     * 删除单个文件
     * @param id
     * @return Boolean
     */
    @Override
    public Boolean del(Integer id) {
        if(archiveFileMapper.deleteById(id)==1){
            return true;
        } else {
            return false;
        }
    }

    /**
     * 删除多个文件
     * @param list
     * @return Integer
     */
    @Override
    public Integer delList(Integer[] list) {
        return archiveFileMapper.deleteBatchIds(Arrays.asList(list));
    }

    /**
     * 添加文件
     * @param archiveFileAddDao
     * @return Integer
     */
    @Override
    public Integer add(ArchiveFileAddDao archiveFileAddDao) {
        System.out.println(archiveFileAddDao);
        return archiveFileMapper.insert(ArchiveFilePo.builder()
                        .archiveId(archiveFileAddDao.getArchiveId())
                        .fileName(archiveFileAddDao.getFileName())
                        .filePath(archiveFileAddDao.getFilePath())
                        .fileSize(archiveFileAddDao.getFileSize())
                        .createTime(new Date())
                .build());
    }
}
