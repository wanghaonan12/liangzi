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
@TableName("pdes_portal-annals_file")
@ApiModel(value = "PdesPortalAnnalsFile对象", description = "年鉴档案文件表；")
public class AnnalsFilePO implements Serializable {

    private static final long serialVersionUID = -5898579670167802111L;
    @ApiModelProperty(value = "主键")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "年鉴ID")
    private String annals_id;

    @ApiModelProperty(value = "附件标题")
    private String file_name;

    @ApiModelProperty(value = "附件大小")
    private String flie_size;

    @ApiModelProperty(value = "后缀")
    private String file_suffix;

    @ApiModelProperty(value = "存储路径")
    private String file_path;

    @ApiModelProperty(value = "备注")
    private String memmo;

    @ApiModelProperty(value = "排序号")
    private String order_seq;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss",timezone = "GMT+8")
    private Date create_time;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss",timezone = "GMT+8")
    private Date modifile_time;


}
