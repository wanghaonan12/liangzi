package com.pde.pdes.portal.archive.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Builder;
import lombok.Data;

/**
 * 开放档案文件更新的实体类
 * @author xiaozp
 * @date 2022-12-21 19：00
 */
@Data
@Builder
public class ArchiveFileUpdateDao {
    /**
     * 档案条目ID
     */
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
