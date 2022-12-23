package com.pde.pdes.portal.archive.po;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * pdes_portal_public_archive_file
 * @author xiaozp
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "DEMO开放档案文件", description = "DEMO开放档案文件")
@TableName("pdes_portal_public_archive_file")
@Builder
public class ArchiveFilePo implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

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

    /**
     * 创建时间
     */
    @TableField(value="create_time")
    private Date createTime;


}