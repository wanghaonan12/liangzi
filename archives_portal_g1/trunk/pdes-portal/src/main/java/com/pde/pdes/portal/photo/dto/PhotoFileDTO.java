package com.pde.pdes.portal.photo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class PhotoFileDTO {
    /**
     * 相册ID
     */
    @NotNull(message="[相册ID]不能为空")
    @ApiModelProperty("相册ID")
    private Integer photoId;
    /**
     * 文件名
     */
    @NotBlank(message="[文件名]不能为空")
    @ApiModelProperty("文件名")
    private String fileName;
    /**
     * 文件路径
     */
    @NotBlank(message="[文件路径]不能为空")
    @ApiModelProperty("文件路径")
    private String filePath;
    /**
     * 文件大小
     */
    @NotNull(message="[文件大小]不能为空")
    @ApiModelProperty("文件大小")
    private Integer fileSize;
    /**
     * 开启封面;0内页;1封面
     */
    @ApiModelProperty("开启封面;0内页;1封面")
    private Integer enableFront;
}
