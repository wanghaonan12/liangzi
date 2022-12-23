package com.pde.pdes.portal.video.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author mth
 * @since 2022-12-01
 * @description: 视频文件表 实体对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("pdes_portal_video_file")
@ApiModel(value = "PdesPortalVideoFile对象", description = "视频档案文件表;")
public class VideoFilePO implements Serializable {

    private static final long serialVersionUID = -2846484713760110510L;
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "视频专辑ID")
    private Integer video_id;

    @ApiModelProperty(value = "文件名")
    private String file_name;

    @ApiModelProperty(value = "文件路径")
    private String file_path;

    @ApiModelProperty(value = "文件大小")
    private Integer file_size;

    @ApiModelProperty(value = "是否为专辑封面;")
    private Boolean is_front_file;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date create_time;


}
