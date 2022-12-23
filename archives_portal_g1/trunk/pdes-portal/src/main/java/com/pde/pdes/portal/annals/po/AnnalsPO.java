package com.pde.pdes.portal.annals.po;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("pdes_portal-annals")
@ApiModel(value = "PdesPortalAnnals对象", description = "年鉴档案；")
public class AnnalsPO implements Serializable {

    private static final long serialVersionUID = 6635770889533278588L;
    @ApiModelProperty(value = "主键")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "年鉴标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private  String content;

    @ApiModelProperty(value = "摘要")
    private String content_abstract;

    @ApiModelProperty(value = "启用发布")
    private Integer enable_publish;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss",timezone = "GMT+8")
    private Date create_time;

    @ApiModelProperty(value = "修改时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss",timezone = "GMT+8")
    private Date modifile_time;

}
