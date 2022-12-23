package com.pde.pdes.portal.news.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * 新闻实体
 * @author 沈建树
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "新闻信息", description = "新闻信息")
@TableName(value = "pdes_portal_news", resultMap = "newsMap")
@Builder
public class NewsPo {
    @ApiModelProperty("文章ID")
    @TableId
    Integer id;

    @ApiModelProperty("标题")
    String title;

    @ApiModelProperty("内容")
    String content;

    @ApiModelProperty("摘要")
    @TableField("content_abstract")
    String contentAbstract;

    @ApiModelProperty("启用发布")
    @TableField("enable_publish")
    Integer enablePublish;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    Date createTime;

    @ApiModelProperty("修改时间")
    @TableField("modified_time")
    Date modifiedTime;

    @ApiModelProperty("新闻附件实体")
    @TableField(exist = false)
    List<NewsFilePo> newsFilePos;
}
