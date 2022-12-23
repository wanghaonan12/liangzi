package com.pde.pdes.portal.photo.po;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@TableName(value = "pdes_portal_photo_file")
@Builder
public class PhotoFilePO {
    /**
     * 主键
     */
    @NotNull(message="[主键]不能为空")
    @ApiModelProperty("主键")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 相册ID
     */
    @ApiModelProperty("相册ID")
    private Integer photo_id;
    /**
     * 文件名
     */
    @ApiModelProperty("文件名")
    private String file_name;
    /**
     * 文件路径
     */
    @ApiModelProperty("文件路径")
    private String file_path;
    /**
     * 文件大小
     */
    @ApiModelProperty("文件大小")
    private Integer file_size;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @TableField(fill = FieldFill.INSERT)
    private Date create_time;
    /**
     * 开启封面;0内页;1封面
     */
    @ApiModelProperty("开启封面;0内页;1封面")
    private Integer enable_front;
}
