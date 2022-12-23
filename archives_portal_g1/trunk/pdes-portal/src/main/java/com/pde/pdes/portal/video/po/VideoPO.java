package com.pde.pdes.portal.video.po;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: mth
 * @date: 2022/11/30
 * @description: 视频档案表 实体对象
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("pdes_portal_video")
@ApiModel(value = "PdesPortalVideo对象", description = "视频档案(专辑);")
public class VideoPO implements Serializable {
    private static final long serialVersionUID = -7333258114503848199L;
    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "专辑名称")
    private String title;

    @ApiModelProperty(value = "描述")
    private String description;

    @ApiModelProperty(value = "启用发布;0待发布;1已发布")
    private Integer enable_publish;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date create_time;

}
