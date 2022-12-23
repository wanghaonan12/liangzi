package com.pde.pdes.portal.news.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author 沈建树
 */
@Data
public class NewsDTO {

    @NotNull(message = "标题不能为空")
    @ApiModelProperty("标题")
    String title;

    @NotNull(message = "内容不能为空")
    @ApiModelProperty("内容")
    String content;

    @NotNull(message = "摘要不能为空")
    @ApiModelProperty("摘要")
    String contentAbstract;


}
