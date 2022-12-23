package com.pde.pdes.portal.archive.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 添加开放档案文件的实体类
 * @author xiaozp
 * @date 2022-12-21 19：00
 */
@Data
@Builder
public class ArchiveFileAddDao {
    /**
     * 档案条目ID
     */
    @ApiModelProperty("档案号")
    @TableField(value="archive_id")
    private Integer archiveId;

    /**
     * 文件名
     */
    @TableField(value="file_name")
    private String fileName;

    /**
     * 文件路径
     */
    @TableField(value="file_path")
    private String filePath;

    /**
     * 文件大小
     */
    @TableField(value="file_size")
    private Integer fileSize;
}
