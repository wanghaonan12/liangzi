package com.pde.pdes.portal.video.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: mth
 * @date: 2022/12/20
 * @description: 视频文件封面 视图对象vo
 */
@Data
@Builder
public class VideoFileFrontListVO implements Serializable {

    private static final long serialVersionUID = 3589685144517908600L;

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "视频文件id")
    private Integer videoFileId;

    @ApiModelProperty(value = "视频文件名称")
    private String fileName;

    @ApiModelProperty(value = "封面文件地址")
    private String filePath;

    @ApiModelProperty(value = "封面文件大小")
    private Integer fileSize;

    @ApiModelProperty(value = "是否为视频文件的封面")
    private Boolean isFrontFile;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
