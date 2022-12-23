package com.pde.pdes.portal.photo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Data
public class PhotoDTO implements Serializable {


    private static final long serialVersionUID = 3722886524307733846L;

    /**
     * 相册名称
     */
    @NotBlank(message="[相册名称]不能为空")
    @ApiModelProperty("相册名称")
    private String title;
    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String description;
    /**
     * 启用发布;0待发布;1已发布
     */
    @NotNull(message="[启用发布;0待发布;1已发布]不能为空")
    @ApiModelProperty("启用发布;0待发布;1已发布")
    private Integer enablePublish;

}
