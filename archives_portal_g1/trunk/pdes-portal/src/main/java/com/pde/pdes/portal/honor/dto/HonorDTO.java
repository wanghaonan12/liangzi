package com.pde.pdes.portal.honor.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @Author chl
 * @Description 相册传参DTO
 * @Date 2022/12/10 11:38
 * @Version 1.0
 */
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "档案相册传参", description = "档案相册传参")
@Builder
public class HonorDTO {

    /**
     * 主键id
     */
    @ApiModelProperty("id")
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
     * 启用发布 0启用，1发布
     */
    @ApiModelProperty("启用发布")
    private Boolean enable_publish;

}
