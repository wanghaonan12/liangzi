package com.pde.pdes.portal.news.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pde.pdes.portal.news.po.NewsFilePo;
import com.pde.pdes.portal.news.po.NewsPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 新闻mapper
 * @author 沈建树
 */
@Mapper
public interface NewsMapper extends BaseMapper<NewsPo> {
    /**
     * 根据符合查询条件的新闻ID去查询所有新闻及一对多新闻附件集合
     * @param ids 查询条件
     * @return 返回新闻列表
     */
    List<NewsPo> getAllNewsBySearchTextResultIds(List<Integer> ids);

    /**
     * 返回所有符合查询条件的新闻ID集合
     * @param searchText 查询条件
     * @return 新闻ID集合
     */
    List<Integer> getAllNewsIdBySearchText(String searchText);
    /**
     * 根据ID去查询对应新闻及一对多新闻附件集合
     * @param id 新闻ID
     * @return 返回新闻实体
     */
    NewsPo getNewsById(Integer id);
}
