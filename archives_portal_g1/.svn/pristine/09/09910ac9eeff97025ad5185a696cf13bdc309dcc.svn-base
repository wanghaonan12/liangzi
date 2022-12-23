package com.pde.pdes.portal.annals.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jtt
 */
@Data
@Builder
public class AnnalsDTO implements Serializable {


    private static final long serialVersionUID = -2248939395984753747L;
    @NotEmpty(message = "标题名称不能为空")
    @ApiModelProperty("标题名称")
    private String title;

    @NotEmpty(message = "内容不能为空")
    @ApiModelProperty("内容")
    private String content;

    @NotEmpty(message = "启用发布不能为空")
    @ApiModelProperty("启用发布")
    private String enable_publish;

    @NotEmpty(message = "创建时间不能为空")
    @ApiModelProperty("创建时间")
    private Date create_time;

}
