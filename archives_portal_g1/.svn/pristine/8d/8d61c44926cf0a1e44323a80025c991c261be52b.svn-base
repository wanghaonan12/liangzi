package com.pde.pdes.portal.video.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author: mth
 * @date: 2022/12/9
 * @description: 视频文件列表 视图对象VO
 */
@Data
@Builder
public class VideoFileListVO implements Serializable {

    private static final long serialVersionUID = 6955304630218715344L;

    @ApiModelProperty(value = "主键")
    private Integer id;

    @ApiModelProperty(value = "视频专辑ID")
    private Integer videoId;

    @ApiModelProperty(value = "文件名")
    private String fileName;

    @ApiModelProperty(value = "文件路径")
    private String filePath;

    @ApiModelProperty(value = "文件大小")
    private Integer fileSize;

    @ApiModelProperty(value = "封面路径")
    private String frontPath;

    @ApiModelProperty(value = "是否为专辑封面;")
    private Boolean isFrontFile;

    @ApiModelProperty(value = "文件封面列表")
    private List<VideoFileFrontListVO> frontList;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;
}
