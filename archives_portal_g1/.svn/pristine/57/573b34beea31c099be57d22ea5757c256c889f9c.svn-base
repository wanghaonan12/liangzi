package com.pde.pdes.portal.news.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;

import java.io.Serializable;
import java.util.Date;

/**
 * 新闻附件实体
 *
 * @author 沈建树
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "新闻附件信息", description = "新闻附件信息")
@TableName("pdes_portal_news_file")
@Builder
public class NewsFilePo implements Serializable {
    @TableId
    @ApiModelProperty("附件ID")
    Integer id;


    @ApiModelProperty("动态新闻ID")
    @TableField("news_id")
    Integer newsId;


    @ApiModelProperty("附件标题")
    @TableField("file_name")
    String fileName;

    @ApiModelProperty("附件大小")
    @TableField("file_size")
    Integer fileSize;

    @ApiModelProperty("后缀")
    @TableField("file_suffix")
    String fileSuffix;

    @ApiModelProperty("存储路径")
    @TableField("file_path")
    String filePath;

    @ApiModelProperty("备注")
    String memo;

    @ApiModelProperty("排序号")
    @TableField("order_seq")
    Integer orderSeq;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    Date createTime;

    @ApiModelProperty("更新时间")
    @TableField("modified_time")
    Date modifiedTime;
}
