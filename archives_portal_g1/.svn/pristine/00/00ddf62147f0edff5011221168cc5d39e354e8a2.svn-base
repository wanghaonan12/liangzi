package com.pde.pdes.portal.honor.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pde.pdes.portal.honor.po.HonorPO;
import com.pde.pdes.portal.honor.vo.HonorVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author chl
 * @Description Honor持久层
 * @Date 2022/12/10 11:39
 * @Version 1.0
 */
@Mapper
public interface HonorMapper extends BaseMapper<HonorPO> {
    /**
     * 根据相册title模糊查询
     * @param title 相册title
     * @return 相册VO列表
     */
    List<HonorVO> selectLikeTile(String title,@Param("ew") Wrapper<HonorPO> queryWrapper);

    /**
     * 查询首页轮播相册
     * @return 相册VO
     */

    List<HonorVO> selectHomePage();

    /**
     * 根据相册title模糊查询已发布相册
     * @param title 相册title
     * @return 相册VO列表
     */
    List<HonorVO> selectByPublishLikeTile(String title);

    /**
     * 根据id来批量更改发布状态
     * @param ids 相册id数据
     * @param enablePublish 发布状态
     * @return 更改结果
     */
    boolean updateByIdAndEnablePublish(List<Integer> ids, Boolean enablePublish);

}
