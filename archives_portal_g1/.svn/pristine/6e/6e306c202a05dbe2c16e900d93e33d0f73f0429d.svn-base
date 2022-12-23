package com.pde.pdes.portal.video.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author: mth
 * @date: 2022/12/20
 * @description: 视频文件更新封面dto
 */
@Data
@Builder
public class VideoFileFrontUpdateDTO implements Serializable {

    private static final long serialVersionUID = 4126130107894151792L;

    @NotNull(message = "视频文件ID不能为空")
    @ApiModelProperty(value = "视频文件ID")
    private Integer fileId;

    @NotNull(message = "视频文件封面ID不能为空")
    @ApiModelProperty(value = "视频文件封面ID")
    private Integer frontId;
}
