package com.pde.pdes.portal.news.service;

import com.pde.pdes.portal.news.po.NewsFilePo;

import java.util.List;

/**
 * 新闻附件服务
 * @author 沈建树
 */
public interface NewsFileService {
    /**
     * 模糊查询获取新闻附件，查询条件为空则返回所有新闻附件
     * @param searchText 查询条件
     * @return 附件列表
     */
    List<NewsFilePo> getFiles(String searchText);

    /**
     * 根据新闻ID获取对应附件列表
     *
     * @param id 新闻ID
     * @return 附件信息列表
     */
    List<NewsFilePo> getFilesByNewsId(Integer id);

    /**
     * 添加新附件
     * @param newsFilePo 附件实体
     * @return 是否添加成功
     */
    boolean addFile(NewsFilePo newsFilePo);

    /**
     * 根据ID删除新闻附件
     * @param id 新闻附件ID
     * @return 是否删除成功
     */
    boolean deleteFileById(Integer id);

    /**
     * 根据ID获取新闻附件
     * @param id 新闻附件ID
     * @return 是否删除成功
     */
    NewsFilePo getFileById(Integer id);
    /**
     * 删除每个新闻ID对应的所有新闻附件
     * @param ids 新闻ID数组
     * @return 是否删除成功
     */
    boolean deleteFilesByNewsIds(Integer[] ids);

}
