package com.pde.pdes.portal.archive.service.Impl;

import com.pde.pdes.portal.archive.dao.ArchiveFileAddDao;
import com.pde.pdes.portal.archive.service.ArchiveFlieService;
import com.pde.pdes.portal.archive.po.ArchiveFilePo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.annotation.Resource;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@RunWith(SpringRunner.class)
class ArchiveFileServiceImplTest {
    @Resource
    private ArchiveFlieService archiveFileService;

    @Test
    void selectAll() {
        System.out.println(archiveFileService.selectAll("1"));
    }

    @Test
    void selectById() {
        System.out.println(archiveFileService.selectById(4));
    }

    @Test
    void update() {
    }

    @Test
    void del() {
        System.out.println(archiveFileService.del(16));
    }

    @Test
    void delList() {
        System.out.println(archiveFileService.delList(new Integer[]{1, 2, 3}));
    }

    @Test
    void add() {
        ArchiveFileAddDao archiveFileAddDao = ArchiveFileAddDao.builder()
                .archiveId(111)
                .fileName("单元测试")
                .filePath("单元测试")
                .fileSize(5)
                .build();
        System.out.println(archiveFileService.add(archiveFileAddDao));
    }
}