package com.pde.pdes.portal.notify.service.impl;

import com.pde.Application;
import com.pde.pdes.portal.notify.po.PortalNotifyFile;
import com.pde.pdes.portal.notify.service.PortalNotifyFileService;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author: jiangyiheng
 * @date: 2022/12/21
 * @description: 公告 notifyFile service 测试类
 */

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class PortalNotifyFileServiceImplTest {

    @Resource
    private PortalNotifyFileService portalNotifyFileServiceImplUnderTest;


    /**
     * 添加公告的附件
     * @throws IOException
     */
    @Test
    public void testAddPortalNotifyFile() throws IOException {
        // Setup
        MultipartFile multipartFile = null;
        String filePath = "D:/a/b";
        File dir = new File(filePath);
        // 检查放置文件的文件夹路径是否存在，不存在则创建
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(filePath + "/filename.txt");
        FileWriter writer = null;
        try {
            // 检查目标文件是否存在，不存在则创建
            if (!file.exists()) {
                file.createNewFile();
            }
            // 向目标文件中写入内容
            writer = new FileWriter(file, true);
            writer.append("your content");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != writer)
                writer.close();
        }

        FileInputStream input = new FileInputStream(file);
        multipartFile = new MockMultipartFile("file", file.getName(), "multipart/form-data", IOUtils.toByteArray(input));

        // Run the test
        final int result = portalNotifyFileServiceImplUnderTest.addPortalNotifyFile(0, multipartFile);

        // Verify the results
        System.out.println(result);

    }

    /**
     * id 查询公告附件
     */
    @Test
    public void testSelectPortalNotifyFileByNotifyId() {

        // Run the test
        final List<PortalNotifyFile> result = portalNotifyFileServiceImplUnderTest.selectPortalNotifyFileByNotifyId(0);

        // Verify the results
        System.out.println(result);

    }

    /**
     * id 删除公告附件
     */
    @Test
    public void testDeletePortalNotifyFileById() {
        // Run the test
        final boolean result = portalNotifyFileServiceImplUnderTest.deletePortalNotifyFileById(18);

        // Verify the results
        System.out.println(result);

    }

    /**
     * 首页的轮播图
     */
    @Test
    public void testSelectPortalNotifyFileByJpg() {

        // Run the test
        final List<PortalNotifyFile> result = portalNotifyFileServiceImplUnderTest.selectPortalNotifyFileByJpg(0);

        // Verify the results
        System.out.println(result);

    }

    /**
     * 批量删除公告的附件
     */
    @Test
    public void testDeletePortalNotifyFileBatchById() {

        // Run the test
        final Integer result = portalNotifyFileServiceImplUnderTest.deletePortalNotifyFileBatchById(Arrays.asList(0));

        // Verify the results
        System.out.println(result);
    }
}
