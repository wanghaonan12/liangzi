package com.pde.pdes.portal.standard.service;

import com.pde.pdes.portal.standard.po.StandardFile;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author wangRich
 * @description 针对表【pdes_portal_standard_file(标准文件表;)】的数据库操作Service
 * @createDate 2022-11-30 10:56:45
 */
@Component
public interface StandardFileService {

    /**
     * 添加standardFile
     *
     * @param file       file
     * @param title      title
     * @param standardId standardId
     * @return 添加状态
     */
    int add(MultipartFile file, String title, int standardId);


    /**
     * 更新StandardFile
     *
     * @param standardFile standardFile
     * @return 更新状态
     */
    boolean update(StandardFile standardFile);


    /**
     *  根据standardFile的id删除standardFile
     *
     * @param id standardFile的id
     * @return 删除状态
     */
    boolean deleteById(Integer id);

    /**
     * 根据StandardId删除standardFile
     *
     * @param id id
     * @return 影响行数
     */
    int deleteByStandardId(Integer id);

    /**
     * 根据StandardId删除standardFile
     *
     * @param ids id
     * @return 影响行数
     */
    int deleteByStandardIds(List<Integer> ids);

    /**
     * 根据Standard的id获取StandardFile列表
     *
     * @param id id
     * @return StandardFile列表
     */
    List<StandardFile> getFileByStandardId(Integer id);

    /**
     * 根据Standard的id获取StandardFile列表
     *
     * @param ids id
     * @return StandardFile列表
     */
    List<StandardFile> getFileByStandardIds(List<Integer> ids);

    /**
     * 根据StandardFile的id获取StandardFile
     *
     * @param id id
     * @return StandardFile列表
     */
    StandardFile getById(Integer id);


}
