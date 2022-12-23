package com.pde.pdes.portal.video.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: mth
 * @date: 2022/12/6
 * @description: 封面文件 vo视图对象
 */
@Data
@Builder
public class FrontFileVO implements Serializable {

    private static final long serialVersionUID = -5694005661505881563L;

    @ApiModelProperty(value = "文件名")
    private String fileName;

    @ApiModelProperty(value = "文件路径")
    private String filePath;

    @ApiModelProperty(value = "文件大小")
    private Integer fileSize;

    @ApiModelProperty(value = "是否为封面")
    private Boolean isFrontFile;

}
