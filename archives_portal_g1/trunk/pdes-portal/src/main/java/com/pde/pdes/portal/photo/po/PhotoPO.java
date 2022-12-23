package com.pde.pdes.portal.photo.po;


import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@TableName(value = "pdes_portal_photo")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhotoPO {
    /**
     *主键
     */
    @ApiModelProperty("主键")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 相册名称
     */
    @ApiModelProperty("相册名称")
    private String title;
    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String description;
    /**
     * 启用发布;0待发布;1已发布
     */
    @ApiModelProperty("启用发布;0待发布;1已发布")
    private Integer enable_publish;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date create_time;
}
