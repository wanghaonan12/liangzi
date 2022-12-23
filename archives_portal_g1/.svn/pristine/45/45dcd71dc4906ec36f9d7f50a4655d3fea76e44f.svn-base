package com.pde.pdes.portal.standard.service.impl;

import com.pde.Application;
import com.pde.pdes.portal.standard.po.StandardFile;
import com.pde.pdes.portal.standard.service.StandardFileService;
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
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class StandardFileServiceImplTest {
    @Resource
    private StandardFileService standardFileServiceImplUnderTest;

    @Test
    public void testAdd() throws IOException {
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
        int result = standardFileServiceImplUnderTest.add(multipartFile, "title", 0);

        // Verify the results
        assertEquals(1, result);
    }

    @Test
    public void testUpdate() {
        // Setup
        final StandardFile standardFile = StandardFile.builder()
                .id(41)
                .standardId(0)
                .fileName("title")
                .filePath("filePath")
                .fileSize(0)
                .createTime(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime())
                .build();

        // Run the test
        final boolean result = standardFileServiceImplUnderTest.update(standardFile);
        assertTrue(result);
    }

    @Test
    public void testDeleteById() {
        final boolean result = standardFileServiceImplUnderTest.deleteById(41);
        assertTrue(result);
    }

    @Test
    public void testDeleteByStandardId() {

        final int result = standardFileServiceImplUnderTest.deleteByStandardId(25);
        assertEquals(1, result);
    }

    @Test
    public void testDeleteByStandardId_StandardFileMapperSelectListReturnsNoItems() {

        final int result = standardFileServiceImplUnderTest.deleteByStandardId(0);
        assertEquals(1, result);
    }

    @Test
    public void testGetFileByStandardId() {

        final List<StandardFile> result = standardFileServiceImplUnderTest.getFileByStandardId(0);
        System.out.println(result);
    }

    @Test
    public void testGetFileByStandardId_StandardFileMapperReturnsNoItems() {

        final List<StandardFile> result = standardFileServiceImplUnderTest.getFileByStandardId(0);
        System.out.println(result);
    }

    @Test
    public void testGetById() {
        // Run the test
        StandardFile result = standardFileServiceImplUnderTest.getById(41);
        System.out.println(result);
    }
}
