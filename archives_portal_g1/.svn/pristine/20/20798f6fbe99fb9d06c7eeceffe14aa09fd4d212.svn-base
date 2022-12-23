package com.pde.pdes.portal.honor.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @Author chl
 * @Description TODO
 * @Date 2022/12/11 18:01
 * @Version 1.0
 */
@Data
@Builder
@ApiModel(value = "批量发布参数")
public class PublishHonorDTO {
    /**
     * 相册id数组
     */
    @ApiModelProperty(name = "ids", value = "需要进行操作发布的相册id")
    List<Integer> ids;

    /**
     * 发布状态
     */
    @ApiModelProperty(name = "enable_publish", value = "发布状态")
    Boolean enable_publish;
}
