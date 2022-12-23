package com.pde.pdes.portal.annals.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jtt
 */
@Data
@Builder
public class AnnalsFileDTO implements Serializable {


    private static final long serialVersionUID = -1527342694315419985L;
    @NotEmpty(message = "年鉴ID不能为空")
    @ApiModelProperty("年鉴ID")
    private String annals_id;

    @NotEmpty(message = "附件标题不能为空")
    @ApiModelProperty("附件标题")
    private String file_name;

    @NotEmpty(message = "附件大小不能为空")
    @ApiModelProperty("附件大小")
    private String file_size;

    @NotEmpty(message = "存储路径不能为空")
    @ApiModelProperty("存储路径")
    private  String file_path;

    @NotEmpty(message = "序号不能为空")
    @ApiModelProperty("排序号")
    private String order_seq;

    @NotEmpty(message = "创建时间不能为空")
    @ApiModelProperty("创建时间")
    private Date create_time;

}
