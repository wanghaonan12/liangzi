DROP TABLE IF EXISTS pdes_portal_use;
CREATE TABLE pdes_portal_use(
    `login_name` VARCHAR(32) NOT NULL   COMMENT '登录名' ,
    `password` VARCHAR(255) NOT NULL   COMMENT '密码' ,
    `gender` SMALLINT NOT NULL   COMMENT '性别;0=男，1=女' ,
    `age` INT(3)    COMMENT '年龄' ,
    `telephone` VARCHAR(11)    COMMENT '手机号码' ,
    `valid_state` SMALLINT NOT NULL  DEFAULT 1 COMMENT '状态;0=删除，1=有效' ,
    `create_time` DATETIME NOT NULL   COMMENT '创建时间' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (login_name)
)  COMMENT = '用户';

DROP TABLE IF EXISTS pdes_portal_layout;
CREATE TABLE pdes_portal_layout(
    `id` INT NOT NULL AUTO_INCREMENT  COMMENT '主键;布局ID' ,
    `section_id` INT NOT NULL   COMMENT '引用栏目ID' ,
    `show_name` VARCHAR(255) NOT NULL   COMMENT '布局显示名' ,
    `layout_style` DECIMAL(2) NOT NULL   COMMENT '布局样式' ,
    `create_time` DATETIME NOT NULL  DEFAULT now() COMMENT '创建时间' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '布局';

DROP TABLE IF EXISTS pdes_portal_section;
CREATE TABLE pdes_portal_section(
    `id` INT NOT NULL AUTO_INCREMENT  COMMENT '栏目ID' ,
    `pid` VARCHAR(32) NOT NULL  DEFAULT 0 COMMENT '父栏目ID' ,
    `mode` DECIMAL(2) NOT NULL   COMMENT '栏目类型;0=文章，1=图片，2=视频，3=文件下载，4=链接' ,
    `show_name` VARCHAR(32) NOT NULL   COMMENT '栏目名称' ,
    `icon` VARCHAR(255)    COMMENT '图标' ,
    `show_type` VARCHAR(255)    COMMENT '展示方式;0=列表，1=卡片；mode=0时生效' ,
    `page_size` INT NOT NULL  DEFAULT 0 COMMENT '分页显示数量;大于0表示分页展示' ,
    `memo` VARCHAR(255)    COMMENT '备注' ,
    `is_default` DECIMAL(2) NOT NULL  DEFAULT 1 COMMENT '是否默认;0=默认，1=非默认' ,
    `create_time` DATETIME NOT NULL  DEFAULT now() COMMENT '创建时间' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    `order_seq` INT NOT NULL  DEFAULT 0 COMMENT '排序号' ,
    PRIMARY KEY (id)
)  COMMENT = '栏目';

DROP TABLE IF EXISTS pdes_portal_navigation;
CREATE TABLE pdes_portal_navigation(
    `id` INT NOT NULL AUTO_INCREMENT  COMMENT '主键;导航ID' ,
    `pid` INT NOT NULL  DEFAULT 0 COMMENT '父导航ID' ,
    `nav_name` VARCHAR(255) NOT NULL   COMMENT '导航名称' ,
    `order_seq` INT NOT NULL  DEFAULT 0 COMMENT '排序号' ,
    `create_time` DATETIME NOT NULL  DEFAULT now() COMMENT '创建时间' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '导航栏';

DROP TABLE IF EXISTS pdes_portal_link;
CREATE TABLE pdes_portal_link(
    `id` VARCHAR(32) NOT NULL   COMMENT '主键;链接ID' ,
    `show_name` VARCHAR(255) NOT NULL   COMMENT '显示名称' ,
    `section_id` INT NOT NULL   COMMENT '归属栏目' ,
    `link_uri` VARCHAR(255) NOT NULL   COMMENT '链接地址' ,
    `link_type` DECIMAL(2) NOT NULL   COMMENT '链接类型;0=内部链接，1=外部链接' ,
    `icon` VARCHAR(255)    COMMENT '图标' ,
    `memo` VARCHAR(255)    COMMENT '备注' ,
    `create_time` DATETIME    COMMENT '创建时间' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    `order_seq` INT NOT NULL  DEFAULT 0 COMMENT '排序号' ,
    PRIMARY KEY (id)
)  COMMENT = '链接';

DROP TABLE IF EXISTS pdes_portal_article;
CREATE TABLE pdes_portal_article(
    `id` INT NOT NULL AUTO_INCREMENT  COMMENT '主键;文章ID' ,
    `section_id` INT NOT NULL   COMMENT '归属栏目ID' ,
    `title` VARCHAR(255) NOT NULL   COMMENT '标题' ,
    `content` TEXT NOT NULL   COMMENT '内容' ,
    `content_abstract` VARCHAR(300)    COMMENT '摘要' ,
    `is_publish` DECIMAL(2) NOT NULL  DEFAULT 0 COMMENT '是否发布;0=待发布，1=已发布' ,
    `created_by` VARCHAR(50) NOT NULL   COMMENT '创建人姓名' ,
    `order_seq` INT NOT NULL  DEFAULT 0 COMMENT '排序号' ,
    `create_time` DATETIME NOT NULL  DEFAULT now() COMMENT '创建时间' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    PRIMARY KEY (id)
)  COMMENT = '文章';

DROP TABLE IF EXISTS pdes_portal_article_file;
CREATE TABLE pdes_portal_article_file(
    `id` INT NOT NULL AUTO_INCREMENT  COMMENT '主键;附件ID' ,
    `article_id` INT NOT NULL   COMMENT '归属文章ID' ,
    `file_name` VARCHAR(255) NOT NULL   COMMENT '附件标题' ,
    `file_size` INT NOT NULL   COMMENT '附件大小' ,
    `file_suffix` VARCHAR(10)    COMMENT '后缀' ,
    `store_id` INT NOT NULL   COMMENT '存储ID' ,
    `store_path` VARCHAR(255) NOT NULL   COMMENT '存储路径' ,
    `memo` VARCHAR(255)    COMMENT '备注' ,
    `order_seq` INT NOT NULL   COMMENT '排序号' ,
    `create_time` DATETIME NOT NULL  DEFAULT now() COMMENT '创建时间' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    `valid_state` DECIMAL(2) NOT NULL  DEFAULT 1 COMMENT '有效标志;1=有效，0=删除' ,
    PRIMARY KEY (id)
)  COMMENT = '文章附件';

DROP TABLE IF EXISTS pdes_portal_storage_config;
CREATE TABLE pdes_portal_storage_config(
    `id` INT NOT NULL AUTO_INCREMENT  COMMENT '主键' ,
    `store_type` VARCHAR(5) NOT NULL   COMMENT '存储类型;FTP，SFTP' ,
    `host` VARCHAR(16) NOT NULL   COMMENT '主机地址' ,
    `port` INT(6) NOT NULL   COMMENT '端口' ,
    `account` VARCHAR(30)    COMMENT '账户' ,
    `password` VARCHAR(100)    COMMENT '口令' ,
    `mode` DECIMAL(2)   DEFAULT 0 COMMENT '主被动模式;0=被动模式，1=主动模式' ,
    `root` VARCHAR(50)    COMMENT '根目录' ,
    `memo` VARCHAR(255)    COMMENT '备注' ,
    `create_time` DATETIME NOT NULL  DEFAULT now() COMMENT '创建时间' ,
    `update_time` DATETIME    COMMENT '更新时间' ,
    `valid_state` DECIMAL(2) NOT NULL   COMMENT '有效标志;0=删除，1=有效' ,
    PRIMARY KEY (id)
)  COMMENT = '存储配置';

