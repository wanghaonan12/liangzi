package com.pde.pdes.portal.photo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pde.pdes.portal.photo.dto.PhotoFileDTO;
import com.pde.pdes.portal.photo.mapper.PhotoFileMapper;
import com.pde.pdes.portal.photo.mapper.PhotoMapper;
import com.pde.pdes.portal.photo.po.PhotoFilePO;
import com.pde.pdes.portal.photo.po.PhotoPO;
import com.pde.pdes.portal.photo.vo.PhotoFileVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoFileServiceImpl extends ServiceImpl<PhotoFileMapper,PhotoFilePO> implements PhotoFileService {
    @Autowired
    PhotoMapper photoMapper;
    @Autowired
    PhotoFileMapper photoFileMapper;

    @Override
    public boolean add(PhotoFileDTO entity) {
        PhotoPO po=photoMapper.selectById(entity.getPhotoId());
        Assert.notNull(po,"没有找到该相册");
        return save(PhotoFilePO.builder()
                .photo_id(entity.getPhotoId())
                .file_name(entity.getFileName())
                .file_path(entity.getFilePath())
                .file_size(entity.getFileSize())
                .enable_front(entity.getEnableFront())
                .build());
    }

    @Override
    public boolean deleteByIds(List<Integer> ids) {
        return removeByIds(ids);
    }


    @Override
    public boolean update(PhotoFilePO po) {
        return updateById(PhotoFilePO.builder()
                .id(po.getId())
                .photo_id(po.getPhoto_id())
                .file_name(po.getFile_name())
                .file_path(po.getFile_path())
                .file_size(po.getFile_size())
                .enable_front(po.getEnable_front())
                .build());
    }

    @Override
    public PhotoFilePO findById(String id) {
        return getById(id);
    }

    @Override
    public List<PhotoFileVO> find(Integer photoId) {
        System.out.println(photoId);
        PhotoPO po = photoMapper.selectById(photoId);
        System.out.println(1);
        Assert.notNull(po,"此id所指相册不存在");
        System.out.println(1);
        List<PhotoFileVO> photoFileVOS=photoFileMapper.selectAllFiles(photoId);

        return photoFileVOS;
    }

    @Override
    public boolean setFront(Integer id) {
        PhotoFilePO photoFilePO=photoFileMapper.selectById(id);
        QueryWrapper<PhotoFilePO> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("photo_id",photoFilePO.getPhoto_id());
        queryWrapper.eq("enable_front",1);
        if (photoFileMapper.selectOne(queryWrapper)!=null){
            PhotoFilePO photoFilePO1=photoFileMapper.selectOne(queryWrapper);
            photoFilePO1.setEnable_front(0);
            photoFileMapper.updateById(photoFilePO1);
            photoFilePO.setEnable_front(1);
            photoFileMapper.updateById(photoFilePO);
        }
        else {
            photoFilePO.setEnable_front(1);
            photoFileMapper.updateById(photoFilePO);
        }
        return true;
    }

    @Override
    public boolean cancelSetFront(Integer id) {
        PhotoFilePO photoFilePO=photoFileMapper.selectById(id);
        photoFilePO.setEnable_front(0);
        photoFileMapper.updateById(photoFilePO);
        return true;
    }
}
