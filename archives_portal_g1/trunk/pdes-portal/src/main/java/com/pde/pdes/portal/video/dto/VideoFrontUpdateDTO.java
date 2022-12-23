package com.pde.pdes.portal.video.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author: mth
 * @date: 2022/12/20
 * @description: 视频专辑更新封面dto
 */
@Data
@Builder
public class VideoFrontUpdateDTO implements Serializable {

    private static final long serialVersionUID = -5132157911342133749L;

    @NotNull(message = "视频专辑ID不能为空")
    @ApiModelProperty(value = "视频文件ID")
    private Integer videoId;

    @NotNull(message = "视频文件ID不能为空")
    @ApiModelProperty(value = "视频文件封面ID")
    private Integer fileId;
}
