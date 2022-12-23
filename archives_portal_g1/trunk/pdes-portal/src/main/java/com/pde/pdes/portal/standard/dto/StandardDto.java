package com.pde.pdes.portal.standard.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author : WangRich
 * @description : StandardDto
 * @date : 2022/11/30 11:24
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StandardDto {
    /**
     * 名称
     */
    @NotBlank(message = "[名称]不能为空")
    @Size(max = 128, message = "编码长度不能超过128")
    @ApiModelProperty("名称")
    @Length(max = 128, message = "编码长度不能超过128")
    private String title;
    /**
     * 描述
     */
    @Size(max = 128, message = "编码长度不能超过128")
    @ApiModelProperty("描述")
    @Length(max = 128, message = "编码长度不能超过128")
    private String description;
    /**
     * 启用发布;0待发布;1已发布
     */
    @NotNull(message = "[启用发布;0待发布;1已发布]不能为空")
    @ApiModelProperty("启用发布;0待发布;1已发布")
    private Integer enablePublish;
    /**
     * 实施日期
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @NotNull(message = "[实施日期]不能为空")
    @ApiModelProperty("实施日期")
    private Date useDate;
}
