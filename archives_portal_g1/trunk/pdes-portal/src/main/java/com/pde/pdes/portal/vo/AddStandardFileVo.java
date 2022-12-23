package com.pde.pdes.portal.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author : WangRich
 * @Description : description
 * @date : 2022/12/19 11:36
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddStandardFileVo {
    @ApiModelProperty(value = "文件标题")
    private String title;

    @ApiModelProperty(value = "文章标准id")
    private String standardId;

    @ApiModelProperty(value = "文件")
    private MultipartFile file;
}
