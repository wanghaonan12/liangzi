package com.pde.pdes.portal.photo.service;


import com.pde.pdes.portal.photo.dto.PhotoFileDTO;
import com.pde.pdes.portal.photo.po.PhotoFilePO;
import com.pde.pdes.portal.photo.vo.PhotoFileVO;

import java.util.List;

public interface PhotoFileService{

    boolean add(PhotoFileDTO entity);

    boolean deleteByIds(List<Integer> ids);

    boolean update(PhotoFilePO po);

    PhotoFilePO findById(String id);

    List<PhotoFileVO> find(Integer photoId);

    boolean setFront(Integer id);

    boolean cancelSetFront(Integer id);





}
