package com.pde.pdes.portal.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: mth
 * @date: 2022/11/17
 * @description: mybatis创建时间处理
 */
@Slf4j
@Component
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("create_time", new Date(), metaObject);
        this.setFieldValByName("modified_time", new Date(), metaObject);
        this.setFieldValByName("createTime", new Date(), metaObject);
        this.setFieldValByName("modifiedTime", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("modified_time", new Date(), metaObject);
        this.setFieldValByName("modifiedTime", new Date(), metaObject);
    }
}
