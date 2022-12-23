package com.pde.pdes.portal.chronicle.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 * @author SYKCOMPUTER
 */
@Data
@Builder
public class PdesPortalChronicleEventsDto {
    /**
     * 标题
     */
    @NotBlank(message="[标题]不能为空")
    @Size(max= 255,message="编码长度不能超过255")
    @ApiModelProperty("标题")
    @Length(max= 255,message="编码长度不能超过255")
    private String title;
    /**
     * 内容
     */
    @NotBlank(message="[内容]不能为空")
    @ApiModelProperty("内容")
    private String content;
    /**
     * 摘要
     */
    @Size(max= 300,message="编码长度不能超过300")
    @ApiModelProperty("摘要")
    @Length(max= 300,message="编码长度不能超过300")
    private String contentAbstract;
    /**
     * 启用发布;0=待发布，1=已发布
     */
    @NotNull(message="[启用发布;0=待发布，1=已发布]不能为空")
    @ApiModelProperty("启用发布;0=待发布，1=已发布")
    private Integer enablePublish;

}
