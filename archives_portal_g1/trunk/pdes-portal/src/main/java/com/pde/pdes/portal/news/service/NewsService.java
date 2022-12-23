package com.pde.pdes.portal.news.service;

import com.pde.pdes.portal.news.po.NewsPo;

import java.util.List;

/**
 * 新闻服务
 * @author 沈建树
 */
public interface NewsService {
    /**
     * 根据ID获取新闻信息
     *
     * @param id 新闻ID
     * @return 新闻信息
     */
    NewsPo getNewsById(Integer id);
    /**
     * 模糊查询获取新闻，查询条件为空则返回所有新闻
     * @param searchText 查询条件
     * @return 列表
     */
    List<NewsPo> getNews(String searchText);
    /**
     * 添加新闻
     * @param newsPo 新闻实体
     * @return 是否添加成功
     */
    boolean addNews(NewsPo newsPo);

    /**
     * 根据ID列表批量删除新闻
     * @param ids 新闻ID列表
     * @return 是否删除成功
     */
    boolean deleteNewsByIds(Integer[] ids);

    /**
     * 根据新闻实体参数的ID更新新闻信息
     * @param newsPo 新闻实体
     * @return 是否更新成功
     */
    boolean update(NewsPo newsPo);
}
