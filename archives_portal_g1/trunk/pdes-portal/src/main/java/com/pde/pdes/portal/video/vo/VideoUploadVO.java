package com.pde.pdes.portal.video.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: mth
 * @date: 2022/12/5
 * @description: 视频上传 视图对象vo
 */
@Data
@Builder
public class VideoUploadVO implements Serializable {

    private static final long serialVersionUID = 2540093515227861652L;

    @ApiModelProperty(value = "文件名")
    private String fileName;

    @ApiModelProperty(value = "文件路径")
    private String filePath;

    @ApiModelProperty(value = "文件大小")
    private Integer fileSize;

    @ApiModelProperty(value = "封面列表")
    private List<FrontFileVO> frontFileInfoList;

}
