package com.pde.pdes.portal.news.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pde.pdes.portal.news.mapper.NewsMapper;
import com.pde.pdes.portal.news.po.NewsPo;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * 新闻服务实现类
 * @author 沈建树
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, NewsPo> implements NewsService {
    @Resource
    NewsMapper newsMapper;
    @Resource
    NewsFileService newsFileService;
    @Override
    public NewsPo getNewsById(Integer id) {
        Assert.hasText(String.valueOf(id), "查询ID不能为空");
        return newsMapper.getNewsById(id);
    }

    @Override
    public List<NewsPo> getNews(String searchText) {
        searchText = "%" + searchText + "%";
        List<Integer> ids = newsMapper.getAllNewsIdBySearchText(searchText);
        if (ids.size() == 0){
            return null;
        }
        return newsMapper.getAllNewsBySearchTextResultIds(ids);
    }

    @Override
    public boolean addNews(NewsPo newsPo) {
        Assert.notNull(newsPo, "保存信息不能为空");
        return save(NewsPo.builder()
                .title(newsPo.getTitle())
                .content(newsPo.getContent())
                .contentAbstract(newsPo.getContentAbstract())
                .enablePublish(newsPo.getEnablePublish()).build());
    }

    @Override
    public boolean deleteNewsByIds(Integer[] ids) {
        Assert.notEmpty(ids, "删除ID不能为空");
        newsFileService.deleteFilesByNewsIds(ids);
        return removeByIds(Arrays.asList(ids));
    }

    @Override
    public boolean update(NewsPo newsPo) {
        Assert.notNull(newsPo, "更新信息不能为空");
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        newsPo.setModifiedTime(new Date());
        return updateById(newsPo);
    }
}
