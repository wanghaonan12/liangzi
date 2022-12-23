package com.pde.pdes.portal.honor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pde.pdes.portal.honor.po.HonorFilePO;
import com.pde.pdes.portal.honor.po.HonorPO;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * @Author chl
 * @Description TODO
 * @Date 2022/12/10 11:39
 * @Version 1.0
 */
@Mapper
public interface HonorFileMapper extends BaseMapper<HonorFilePO> {

    /**
     * 根据相册id查询图片
     * @param honorId 相册id
     * @return 图片列表
     */
    List<HonorFilePO> selectAllByHonorId(Integer honorId);

    /**
     * 根据相册id查询此相册图片id
     * @param honorId 相册id
     * @return 图片id列表
     */
    List<Integer> selectHonorFileIdByHonorId(Integer honorId);

    /**
     * 根据相册id和是否为封面查询图片
     * @param honorId  相册id
     * @param enableFront 是否为封面
     * @return 图片对象
     */
    HonorFilePO selectByHonorIdAndEnableFront(Integer honorId,Boolean enableFront);



    /**
     * 根据是否为封面查询图片
     * @param enableFront  是否为封面
     * @return 图片列表
     */
//    List<HonorFilePO> selectByEnableFront(boolean enableFront);
}
