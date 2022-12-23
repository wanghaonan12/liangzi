package com.pde.pdes.portal.news.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.cj.util.StringUtils;
import com.pde.pdes.portal.news.mapper.NewsFileMapper;
import com.pde.pdes.portal.news.po.NewsFilePo;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * 新闻附件服务实现类
 * @author 沈建树
 */
@Service
public class NewsFileServiceImpl extends ServiceImpl<NewsFileMapper, NewsFilePo> implements NewsFileService {

    @Override
    public List<NewsFilePo> getFiles(String searchText) {
        if (StringUtils.isNullOrEmpty(searchText)) {
            return list();
        }
        return list(Wrappers.lambdaQuery(NewsFilePo.class).like(NewsFilePo::getFileName, searchText));
    }

    @Override
    public List<NewsFilePo> getFilesByNewsId(Integer id) {
        Assert.hasText(String.valueOf(id),"查询ID不能为空");
        return list(Wrappers.lambdaQuery(NewsFilePo.class).eq(NewsFilePo::getNewsId,id));
    }

    @Override
    public boolean addFile(NewsFilePo newsFilePo) {
        Assert.notNull(newsFilePo,"保存信息不能为空");
        return save(newsFilePo);
    }

    @Override
    public boolean deleteFileById(Integer id) {
        Assert.notNull(id,"ID不能为空");
        return removeById(id);
    }

    @Override
    public NewsFilePo getFileById(Integer id) {
        Assert.notNull(id,"ID不能为空");
        return getById(id);
    }

    @Override
    public boolean deleteFilesByNewsIds(Integer[] ids) {
        Assert.notEmpty(ids,"新闻id数组不能为空");
        boolean flag = false;
        for (Integer id : ids) {
            flag = remove(Wrappers.lambdaQuery(NewsFilePo.class).eq(NewsFilePo::getNewsId,id));
        }
        return flag;
    }
}
