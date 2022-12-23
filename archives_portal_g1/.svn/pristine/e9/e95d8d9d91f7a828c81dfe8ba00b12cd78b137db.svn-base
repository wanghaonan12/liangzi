package com.pde.pdes.portal.photo.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pde.pdes.portal.honor.po.HonorFilePO;
import com.pde.pdes.portal.photo.dto.PhotoDTO;
import com.pde.pdes.portal.photo.mapper.PhotoFileMapper;
import com.pde.pdes.portal.photo.mapper.PhotoMapper;
import com.pde.pdes.portal.photo.po.PhotoFilePO;
import com.pde.pdes.portal.photo.po.PhotoPO;
import com.pde.pdes.portal.photo.vo.PhotoVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PhotoServiceImpl extends ServiceImpl<PhotoMapper, PhotoPO> implements PhotoService {

    @Autowired
    private PhotoMapper photoMapper;
    @Autowired
    private PhotoFileMapper photoFileMapper;


    @Override
    public boolean add(PhotoDTO entity) {
        Assert.notNull(entity, "保存对象不能为空.");
        return save(PhotoPO.builder()
                .title(entity.getTitle())
                .description(entity.getDescription())
                .enable_publish(entity.getEnablePublish())
                .build());
    }

    @Override
    public boolean deleteByIds(List<Integer> ids) {
        // 删除相册对应照片
        ids.forEach(id -> {
            photoFileMapper.delete(new QueryWrapper<PhotoFilePO>().eq("photo_id", id));
        });

//        for (Integer idEach : id) {
//            List<PhotoFilePO> photoFilePOS = photoFileMapper.selectAllFiles(idEach);
////            photoFileMapper.deleteBatchIds();
//            photoFilePOS.stream().forEach(photo -> {
//                photoFileMapper.deleteById(photo.getId());
//            });
//        }
        photoMapper.deleteBatchIds(ids);
        return true;
    }

    @Override
    public boolean update(PhotoPO po) {

        return updateById(PhotoPO.builder()
                .id(po.getId())
                .title(po.getTitle())
                .description(po.getDescription())
                .enable_publish(po.getEnable_publish())
                .build());
    }

    @Override
    public PhotoPO findById(String id) {
        Assert.hasText(id, "查询条件不能为空.");
        return getById(id);
    }

    @Override
    public List<PhotoVO> find(String searchText) {
        List<PhotoVO> photoVOS = photoMapper.selectPhoto(searchText);
        for (PhotoVO photoVO : photoVOS) {
            if (photoVO.getFile_path() == null) {
                photoVO.setFile_path("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fi-1.wzsky.net%2F2020%2F9%2F9%2FW3dtOnN5LnBuZyxyOjEzLGI6MTNd%2Fd14d238c-2165-4971-8638-ad627ccb4ba9.jpg&refer=http%3A%2F%2Fi-1.wzsky.net&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1673059385&t=3b93dee1e61dcc599c080555509913e7");
            }
        }
        return photoVOS;
    }

    @Override
    public boolean cancelPublished(List<Integer> ids) {
        List<Integer> count = new ArrayList<>();
        ids.forEach(id ->{
            PhotoPO po = photoMapper.selectById(id);
            po.setEnable_publish(0);
            int i1 = photoMapper.updateById(po);
            count.add(i1);
        });
        return count.size()>0;
    }

    @Override
    public boolean toPublished(List<Integer> ids) {
        List<Integer> count = new ArrayList<>();
        ids.forEach(id ->{
            PhotoPO po = photoMapper.selectById(id);
            po.setEnable_publish(1);
            int i1 = photoMapper.updateById(po);
            count.add(i1);
        });
        return count.size()>0;
    }

    @Override
    public List<PhotoVO> findCarouselList() {
        return photoMapper.selectHomePage();
    }
}
