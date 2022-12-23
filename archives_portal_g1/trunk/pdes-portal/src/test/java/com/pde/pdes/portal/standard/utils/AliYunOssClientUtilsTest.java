package com.pde.pdes.portal.standard.utils;

import com.pde.Application;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jiangyiheng
 * @date 2022-12-20 19:34
 */
@SpringBootTest(classes = Application.class)
class AliYunOssClientUtilsTest {

    @Resource
    private AliYunOssClientUtils aliYunOssClientUtils;

    @Test
    void removeObject() {
        //https://wang-rich.oss-cn-hangzhou.aliyuncs.com/LiangZi/2022-12-09/18:30:42/file_8125486872090104375.md
        String[] split = "https://wang-rich.oss-cn-hangzhou.aliyuncs.com/LiangZi/2022-12-09/18:30:42/file_8125486872090104375.md".split("com/");
        for (String s : split) {
            System.out.println(s);
        }
//        aliYunOssClientUtils.removeObject("LiangZi/2022-12-20/19:37:08/file_7930483016481059472.jpg");
    }

    @Test
    void removeObjectBatch() {
        ArrayList<String> list = new ArrayList<>(5);
        list.add("LiangZi/2022-12-09/18:35:03/file_3584387051869397244.jpg");
        list.add("LiangZi/2022-12-09/18:36:48/file_8648933887296881638.jpg");
        aliYunOssClientUtils.removeObjectBatch(list);
    }
}