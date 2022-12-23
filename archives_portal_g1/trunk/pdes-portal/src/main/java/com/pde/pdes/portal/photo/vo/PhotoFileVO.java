package com.pde.pdes.portal.photo.vo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class PhotoFileVO {
    private Integer id;
    private Integer photo_id;
    private String file_name;
    private String file_path;
    private Integer file_size;
    private Date create_time;
    private Integer enable_front;
}
