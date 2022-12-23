package com.pde.pdes.portal.photo.service;

import com.pde.pdes.portal.photo.dto.PhotoDTO;
import com.pde.pdes.portal.photo.po.PhotoPO;
import com.pde.pdes.portal.photo.vo.PhotoVO;

import java.util.List;

public interface PhotoService {
    /**
     * 增
     * @param entity
     * @return
     */
    boolean add(PhotoDTO entity);

    /**
     * 删
     * @param id
     * @return
     */
    boolean deleteByIds(List<Integer> id);

    /**
     * 改
     * @param po
     * @return
     */
    boolean update(PhotoPO po);

    /**
     * id单查
     * @param id
     * @return
     */
    PhotoPO findById(String id);

    /**
     * 内容多查
     * @param searchText
     * @return
     */
    List<PhotoVO> find(String searchText);

    /**
     * 批量取消发布接口
     * @param ids
     * @return
     */
    boolean cancelPublished(List<Integer> ids);

    /**
     * 批量发布接口
     * @param ids
     * @return
     */
    boolean toPublished(List<Integer> ids);

    /**
     * 首页轮播图查询列表
     * @return
     */
    List<PhotoVO> findCarouselList();
}
