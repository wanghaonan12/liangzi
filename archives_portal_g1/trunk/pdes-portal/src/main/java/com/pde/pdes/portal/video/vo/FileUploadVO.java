package com.pde.pdes.portal.video.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: mth
 * @date: 2022/12/4
 * @description: 文件上传 vo视图对象
 */
@Data
@Builder
public class FileUploadVO implements Serializable {

    private static final long serialVersionUID = -8727911755484541056L;

    @ApiModelProperty(value = "文件名")
    private String fileName;

    @ApiModelProperty(value = "文件路径")
    private String filePath;

    @ApiModelProperty(value = "文件大小")
    private Integer fileSize;
}
