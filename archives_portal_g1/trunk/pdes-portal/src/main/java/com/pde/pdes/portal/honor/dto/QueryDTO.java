package com.pde.pdes.portal.honor.dto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @Author chl
 * @Description 搜索参数DTO
 * @Date 2022/12/10 11:37
 * @Version 1.0
 */
@Data
@Builder
@ApiModel(value = "搜索参数")
public class QueryDTO {

    @ApiModelProperty(name = "pageNum", value = "页码")
    private Integer pageNum;

    @ApiModelProperty(name = "pageSize", value = "每页数量")
    private Integer pageSize;

    @ApiModelProperty(name = "title", value = "标题内容")
    private String title;

//    @ApiModelProperty(name = "enablePublish", value = "是否发布,0未发布，1发布")
//    private Integer enablePublish;

}
