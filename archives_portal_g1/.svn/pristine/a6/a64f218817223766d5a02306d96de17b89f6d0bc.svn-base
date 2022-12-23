package com.pde.pdes.portal.video.po;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: mth
 * @date: 2022/12/5
 * @description: 视频文件封面 实体对象
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("pdes_portal_video_file_front")
@ApiModel(value = "PdesPortalVideoFileFront对象", description = "视频档案文件封面表;")
public class VideoFileFrontPO implements Serializable {

    private static final long serialVersionUID = 1902414070809408520L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "视频文件ID")
    private Integer video_file_id;

    @ApiModelProperty(value = "文件名")
    private String file_name;

    @ApiModelProperty(value = "文件路径")
    private String file_path;

    @ApiModelProperty(value = "文件大小")
    private Integer file_size;

    @ApiModelProperty(value = "是否为视频封面;")
    private Boolean is_front_file;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date create_time;


}
