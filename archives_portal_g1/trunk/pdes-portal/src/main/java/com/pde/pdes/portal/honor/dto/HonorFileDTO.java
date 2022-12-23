package com.pde.pdes.portal.honor.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author chl
 * @Description 图片传参DTO
 * @Date 2022/12/10 11:37
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "新增档案图片传参", description = "新增档案图片传参")
@Builder
public class HonorFileDTO {


    @ApiModelProperty("相片id")
    private Integer id;

    /**
     * 相册id
     */
    @ApiModelProperty("相册id")
    private Integer honor_id;
    /**
     * 文件名
     */
    @ApiModelProperty("文件名")
    private String file_name;
    /**
     * 文件地址
     */
    @ApiModelProperty("文件地址")
    private String file_path;

    /**
     * 是否开启封面 0内页，1封面
     */
    @ApiModelProperty("是否设为封面，0内页，1封面")
    private Boolean enable_front;

}
