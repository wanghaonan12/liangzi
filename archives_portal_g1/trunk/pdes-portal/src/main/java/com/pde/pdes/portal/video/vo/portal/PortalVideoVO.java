package com.pde.pdes.portal.video.vo.portal;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: mth
 * @date: 2022/12/7
 * @description: 首页-视频专辑 vo视图对象
 */
@Data
@Builder
public class PortalVideoVO implements Serializable {

    private static final long serialVersionUID = 4004763217262308128L;

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "封面路径")
    private String frontPath;

}
