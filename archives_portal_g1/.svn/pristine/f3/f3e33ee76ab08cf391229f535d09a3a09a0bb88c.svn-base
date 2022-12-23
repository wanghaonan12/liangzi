package com.pde.pdes.portal.video.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: mth
 * @date: 2022/12/6
 * @description: 视频专辑列表 vo视图对象
 */
@Data
@Builder
public class VideoListVO implements Serializable {

    private static final long serialVersionUID = -6138930647512454120L;

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "专辑名称")
    private String title;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "封面地址")
    private String frontPath;

    @ApiModelProperty(value = "启用发布;0待发布;1已发布")
    private Integer enablePublish;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
