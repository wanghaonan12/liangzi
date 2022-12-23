package com.pde.pdes.portal.honor.po;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author chl
 * @Description 荣誉档案相册PO
 * @Date 2022/12/10 11:37
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "荣誉档案照片相册", description = "荣誉档案照片相册")
@TableName("pdes_portal_honor")
@Builder
public class HonorPO implements Serializable {

    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 标题
     */
    @ApiModelProperty("标题")
    private String title;
    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String description;
    /**
     * 启用发布 false待发布，true已发布
     */
    @TableField(value = "enable_publish")
    @ApiModelProperty("启用发布")
    private boolean enable_publish;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty("创建时间")
    private Date create_time;


}
