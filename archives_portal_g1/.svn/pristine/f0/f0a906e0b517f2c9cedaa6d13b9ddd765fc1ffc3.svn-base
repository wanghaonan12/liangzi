package com.pde.pdes.portal.standard.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author : WangRich
 * @description : StandardFileDto
 * @date : 2022/11/30 11:16
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StandardFileDto {
    /**
     * 标准ID
     */
    @NotNull(message = "[标准ID]不能为空")
    @ApiModelProperty("标准ID")
    private Integer standardId;
    /**
     * 文件名
     */
    @NotBlank(message = "[文件名]不能为空")
    @Size(max = 255, message = "编码长度不能超过255")
    @ApiModelProperty("文件名")
    @Length(max = 255, message = "编码长度不能超过255")
    private String fileName;
    /**
     * 文件路径
     */
    @NotBlank(message = "[文件路径]不能为空")
    @Size(max = 255, message = "编码长度不能超过255")
    @ApiModelProperty("文件路径")
    @Length(max = 255, message = "编码长度不能超过255")
    private String filePath;
    /**
     * 文件大小
     */
    @NotNull(message = "[文件大小]不能为空")
    @ApiModelProperty("文件大小")
    private Integer fileSize;

}
