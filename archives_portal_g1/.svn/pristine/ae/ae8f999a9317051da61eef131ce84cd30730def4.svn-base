package com.pde.pdes.portal.standard.po;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.io.Serializable;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 标准文件表;
 *
 * @author wangRich
 * @TableName pdes_portal_standard_file
 */
@Builder
@Data
@TableName("pdes_portal_standard_file")
public class StandardFile implements Serializable {

    private static final long serialVersionUID = -7156030940274350881L;
    /**
     * 主键
     */
    @ApiModelProperty("主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 标准ID
     */
    @ApiModelProperty("标准ID")
    @TableField(value = "standard_id")
    private Integer standardId;
    /**
     * 文件名
     */
    @NotBlank(message = "[文件名]不能为空")
    @Size(max = 255, message = "编码长度不能超过255")
    @ApiModelProperty("文件名")
    @Length(max = 255, message = "编码长度不能超过255")
    @TableField(value = "file_name")
    private String fileName;
    /**
     * 文件路径
     */
    @Size(max = 255, message = "编码长度不能超过255")
    @ApiModelProperty("文件路径")
    @Length(max = 255, message = "编码长度不能超过255")
    @TableField(value = "file_path")
    private String filePath;
    /**
     * 文件大小
     */
    @ApiModelProperty("文件大小")
    @TableField(value = "file_size")
    private Integer fileSize;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT, value = "create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("创建时间")
    private Date createTime;
}
