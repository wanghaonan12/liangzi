package com.pde.pdes.portal.chronicle.service.impl;

/**
 * @author : ykShen
 * @Description :
 * @date : 2022-12-09 18:39
 */
import com.pde.Application;
import com.pde.pdes.portal.chronicle.dto.PdesPortalChronicleEventsDto;
import com.pde.pdes.portal.chronicle.dto.PdesPortalChronicleEventsFileDto;
import com.pde.pdes.portal.chronicle.po.PdesPortalChronicleEvents;
import com.pde.pdes.portal.chronicle.po.PdesPortalChronicleEventsFile;
import com.pde.pdes.portal.chronicle.service.PdesPortalChronicleEventsFileService;
import com.pde.pdes.portal.chronicle.service.PdesPortalChronicleEventsService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = Application.class)
public class ChronicleServiceTest {
    @Autowired
    PdesPortalChronicleEventsService pdesPortalChronicleEventsService;
    @Autowired
    PdesPortalChronicleEventsFileService pdesPortalChronicleEventsFileService;


    /**
     * 查找大事记id为8的附件列表
     */
    @Test
    void selectChronicleFileByChronicleId() {
        final List<PdesPortalChronicleEventsFile> files = pdesPortalChronicleEventsFileService.findByChronicleId(8);
        System.out.println("~~~~~~~~~~~~");
        files.forEach(System.out::println);
        Assert.assertThat(files, Matchers.notNullValue());
        System.out.println("~~~~~~~~~~~~");
    }

//    @Test
//    void isTopChronicleFile() {
//        List<Integer> ids = new  ArrayList();
//        ids.add(26);
//        ids.add(27);
//        System.out.println( pdesPortalChronicleEventsFileService.isTop(1,ids));
//    }

    /**
     * 查找大事记id为8的详情
     */
    @Test
    void selectChronicleById() {
        final PdesPortalChronicleEvents files = pdesPortalChronicleEventsService.findById("8");
        System.out.println("~~~~~~~~~~~~");
        System.out.println(files);
        Assert.assertThat(files, Matchers.notNullValue(PdesPortalChronicleEvents.class));
        System.out.println("~~~~~~~~~~~~");
    }

    /**
     * 查找大事记附件id为14的信息
     */
    @Test
    void selectChronicleFileById() {
        final PdesPortalChronicleEventsFile files = pdesPortalChronicleEventsFileService.findById("26");
        System.out.println("~~~~~~~~~~~~");
        System.out.println(files);
        Assert.assertThat(files, Matchers.notNullValue(PdesPortalChronicleEventsFile.class));
        System.out.println("~~~~~~~~~~~~");
    }

    /**
     * 删除大事记id为8的附件列表
     */
    @Test
    void deleteChronicleFileById() {
        boolean files = pdesPortalChronicleEventsFileService.deleteById("21");
        System.out.println("~~~~~~~~~~~~");
        System.out.println(files);
        Assert.assertThat(files, Matchers.is(true));
        System.out.println("~~~~~~~~~~~~");
    }

    /**
     * 删除大事记id为14的附件列表
     */
    @Test
    void deleteChronicleById() {
        boolean files = pdesPortalChronicleEventsService.deleteById("14");
        System.out.println("~~~~~~~~~~~~");
        System.out.println(files);
        Assert.assertThat(files, Matchers.is(true));
        System.out.println("~~~~~~~~~~~~");
    }

    /**
     * 添加大事记附件
     */
    @Test
    void addFile() {
        final PdesPortalChronicleEventsFileDto pde = PdesPortalChronicleEventsFileDto.builder()
                .chronicleEventsId(6)
                .fileName("meeting.jpg")
                .filePath("http://uplaod-189989.oss-cn-hangzhou.aliyuncs.com/meeting.jpg")
                .fileSize(21232)
                .fileSuffix("jpg")
                .orderSeq(1)
                .build();
        boolean files = pdesPortalChronicleEventsFileService.add(pde);
        System.out.println("~~~~~~~~~~~~");
        System.out.println(files);
        Assert.assertThat(files, Matchers.is(true));
        System.out.println("~~~~~~~~~~~~");
    }

    /**
     * 修改大事记附件
     */
    @Test
    void updateFile() {
        final PdesPortalChronicleEventsFile pde = PdesPortalChronicleEventsFile.builder()
                .id(20)
                .chronicleEventsId(6)
                .fileName("meeting.jpg")
                .filePath("http://uplaod-189989.oss-cn-hangzhou.aliyuncs.com/meeting.jpg")
                .fileSize(21232)
                .fileSuffix("jpg")
                .orderSeq(1)
                .build();
        boolean files = pdesPortalChronicleEventsFileService.updateEvent(pde);
        System.out.println("~~~~~~~~~~~~");
        System.out.println(files);
        Assert.assertThat(files, Matchers.is(true));
        System.out.println("~~~~~~~~~~~~");
    }

    /**
     * 添加大事记
     */
    @Test
    void addChronicle() {
        final PdesPortalChronicleEventsDto pde = PdesPortalChronicleEventsDto.builder()
                .contentAbstract("国家档案局优秀科技成果奖励办法")
                .title("国家档案局关于印发《国家档案局优秀科技成果奖励办法》的通知")
                .enablePublish(0)
                .content("各省、自治区、直辖市档案局，新疆生产建设兵团档案局，" +
                        "中央和国家机关各部委档案部门，中央军委办公厅保密和档" +
                        "案局，各人民团体档案部门，各中央企业档案部门：" +
                        "现将《国家档案局优秀科技成果奖励办法》印发给你们，" +
                        "请认真遵照执行。")
                .build();
        boolean files = pdesPortalChronicleEventsService.add(pde);
        System.out.println("~~~~~~~~~~~~");
        System.out.println(files);
        Assert.assertThat(files, Matchers.is(true));
        System.out.println("~~~~~~~~~~~~");
    }


    /**
     * 修改大事记
     */
    @Test
    void updateChronicle() {
        final PdesPortalChronicleEvents pde = PdesPortalChronicleEvents.builder()
                .id(10)
                .contentAbstract("国家档案局优秀科技成果奖励办法")
                .title("国家档案局关于印发《国家档案局优秀科技成果奖励办法》的通知")
                .enablePublish(0)
                .content("各省、自治区、直辖市档案局，新疆生产建设兵团档案局，" +
                        "中央和国家机关各部委档案部门，中央军委办公厅保密和档" +
                        "案局，各人民团体档案部门，各中央企业档案部门：" +
                        "现将《国家档案局优秀科技成果奖励办法》印发给你们，" +
                        "请认真遵照执行。")
                .build();
        boolean files = pdesPortalChronicleEventsService.updateEvent(pde);
        System.out.println("~~~~~~~~~~~~");
        System.out.println(files);
        Assert.assertThat(files, Matchers.is(true));
        System.out.println("~~~~~~~~~~~~");
    }

    /**
     * 批量删除大事记附件
     */
    @Test
    void deleteChronicleFileByIds() {
        List<Integer> ids=new ArrayList<>();
        ids.add(16);
        ids.add(25);
        boolean files = pdesPortalChronicleEventsFileService.deleteByIds(ids);
        System.out.println(files);
        Assert.assertThat(files, Matchers.is(true));
    }
    /**
     * 批量删除大事记
     */
    @Test
    void deleteChronicleByIds() {
        List<Integer> ids=new ArrayList<>();
        ids.add(16);
        ids.add(15);
        boolean files = pdesPortalChronicleEventsService.deleteByIds(ids);
        System.out.println(files);
        Assert.assertThat(files, Matchers.is(true));

    }

    /**
     * 模糊查询大事记附件
     */
    @Test
    void findAllChronicleFile() {
        final List<PdesPortalChronicleEventsFile> files = pdesPortalChronicleEventsFileService.find("");
        Assert.assertThat(files, Matchers.notNullValue());
        System.out.println(files);

    }


    /**
     * 模糊查询大事记
     */
    @Test
    void findAllChronicle() {
        final List<PdesPortalChronicleEvents> files = pdesPortalChronicleEventsService.find("");
        Assert.assertThat(files, Matchers.notNullValue());
        System.out.println(files);
    }
}
