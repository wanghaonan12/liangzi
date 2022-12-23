package com.pde.pdes.portal.video.dto;

import com.pde.pdes.portal.video.vo.FrontFileVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author: mth
 * @date: 2022/12/1
 * @description: 视频文件dto
 */
@Data
@Builder
public class VideoFileDTO implements Serializable {

    private static final long serialVersionUID = 2766508632804215293L;

    @NotNull(message = "视频专辑ID不能为空")
    @ApiModelProperty(value = "视频专辑ID")
    private Integer videoId;

    @NotEmpty(message = "文件名不能为空")
    @ApiModelProperty(value = "文件名")
    private String fileName;

    @NotEmpty(message = "文件路径不能为空")
    @ApiModelProperty(value = "文件路径")
    private String filePath;

    @NotNull(message = "文件大小不能为空")
    @ApiModelProperty(value = "文件大小")
    private Integer fileSize;

    @ApiModelProperty(value = "文件大小")
    private List<FrontFileVO> frontFileInfoList;

}
