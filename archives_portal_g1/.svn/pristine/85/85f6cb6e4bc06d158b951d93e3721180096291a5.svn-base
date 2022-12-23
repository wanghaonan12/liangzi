package com.pde.pdes.portal.archive.service.Impl;

import com.pde.pdes.portal.archive.dao.ArchiveUpdateDao;
import com.pde.pdes.portal.archive.po.ArchivePo;
import com.pde.pdes.portal.archive.service.ArchiveService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xiaozp
 * @Description TODO
 * @date 2022-12-21 9：00
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class ArchiveServiceImplTest {
    @Resource
    private ArchiveService archiveService;

    /**
     * 前端页面展示开放档案
     */
    @Test
    void selectAll() {
         System.out.println(archiveService.selectAll("1"));
    }

    /**
     * 后端页面展示开放档案
     */
    @Test
    void selectAll2() {
        System.out.println(archiveService.selectAll2("1"));
    }

    /**
     * 通过id搜索开放档案
     */
    @Test
    void selectById() {
        System.out.println(archiveService.selectById(4));
    }

    /**
     * 更新开放档案信息
     */
    @Test
    void update() {
        System.out.println(archiveService.update(
                ArchiveUpdateDao.builder()
                        .id(1)
                        .securityClass("绝密")
                        .enablePublish((short) 0)
                        .build()
        ));
    }

    /**
     * 删除单个
     */
    @Test
    void del() {
        System.out.println(archiveService.del(16));
    }

    /**
     * 删除多个
     */
    @Test
    void delList() {
        System.out.println(archiveService.delList(new Integer[]{1, 2, 3}));
    }

    /**
     * 新增开放档案
     */
    @Test
    void add() {
        ArchivePo archivePo = ArchivePo.builder()
                .archivalCode("202212200001")
                .fonds("南京工业")
                .year("2022")
                .securityClass("绝密")
                .retentionPeriod("永久")
                .title("11111")
                .enablePublish((short) 0)
                .createTime(new Date())
                .modifiedTime(new Date())
                .build();
        System.out.println(archiveService.add(archivePo));
        System.out.println(archivePo.getId());
    }
}