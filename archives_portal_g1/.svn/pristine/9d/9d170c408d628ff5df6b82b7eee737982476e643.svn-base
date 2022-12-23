package com.pde.pdes.portal.video.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author: mth
 * @date: 2022/12/6
 * @description: 视频文件封面dto
 */
@Data
@Builder
public class VideoFileFrontDTO implements Serializable {

    private static final long serialVersionUID = -2960928555987766490L;

    @NotNull(message = "视频文件ID不能为空")
    @ApiModelProperty(value = "视频文件ID")
    private Integer videoFileId;

    @NotEmpty(message = "文件名不能为空")
    @ApiModelProperty(value = "文件名")
    private String fileName;

    @NotEmpty(message = "文件路径不能为空")
    @ApiModelProperty(value = "文件路径")
    private String filePath;

    @NotNull(message = "文件大小不能为空")
    @ApiModelProperty(value = "文件大小")
    private Integer fileSize;

    @NotNull(message = "是否为视频封面不能为空")
    @ApiModelProperty(value = "是否为视频封面")
    private Boolean isFrontFile;
}
