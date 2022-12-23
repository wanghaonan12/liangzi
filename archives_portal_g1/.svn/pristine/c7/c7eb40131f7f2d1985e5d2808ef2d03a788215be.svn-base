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
 * @Description 荣誉档案照片PO
 * @Date 2022/12/10 11:36
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "荣誉档案照片", description = "荣誉档案照片")
@TableName("pdes_portal_honor_file")
@Builder
public class HonorFilePO implements Serializable {
    /**
     * 主键id
     */
    @ApiModelProperty("id")
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
     * 相册id
     */
    @TableField(value = "honor_id")
    @ApiModelProperty("相册id")
    private Integer honor_id;
    /**
     * 文件名
     */
    @TableField(value = "file_name")
    @ApiModelProperty("文件名")
    private String file_name;
    /**
     * 文件地址
     */
    @TableField(value = "file_path")
    @ApiModelProperty("文件地址")
    private String file_path;
    /**
     * 文件大小
     */
    @TableField(value = "file_size")
    @ApiModelProperty("文件大小")
    private Integer file_size;
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty("创建时间")
    private Date create_time;

    /**
     * 开启封面 0内页，1封面
     */
    @TableField(value = "enable_front")
    @ApiModelProperty("开启封面")
    private boolean enable_front;

}
