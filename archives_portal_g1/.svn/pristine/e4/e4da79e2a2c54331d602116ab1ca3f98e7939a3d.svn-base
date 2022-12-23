package com.pde.pdes.portal.honor.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.pde.pdes.portal.honor.dto.HonorDTO;
import com.pde.pdes.portal.honor.dto.HonorFileDTO;
import com.pde.pdes.portal.honor.dto.PublishHonorDTO;
import com.pde.pdes.portal.honor.po.HonorFilePO;
import com.pde.pdes.portal.honor.vo.HonorVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author chl
 * @Description TODO
 * @Date 2022/12/12 9:43
 * @Version 1.0
 */
@SpringBootTest
@RunWith(JUnit4.class)
class HonorServiceTest {


    @Resource
    public HonorService honorService;

    @Test
    void addHonor() {
        HonorDTO honorDTO = HonorDTO.builder()
                .title("单元测试")
                .description("单元测试")
                .enable_publish(true)
                .build();
        Boolean res = honorService.addHonor(honorDTO);
        Assertions.assertTrue(res);
    }

    @Test
    void removeById() {
        Integer[] ids = new Integer[1];
        ids[0] = 15;
        boolean res = honorService.removeById(ids);
        Assertions.assertTrue(res);
    }

    @Test
    void update() {
        HonorDTO honorDTO = HonorDTO.builder()
                .id(15)
                .title("单元测试2")
                .description("单元测试2")
                .enable_publish(true)
                .build();
        boolean res = honorService.update(honorDTO);
        Assertions.assertTrue(res);
    }

    @Test
    void findImage() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date d = null;
        //这里会有一个异常，所以要用try catch捕获异常
        try {
            d = sdf.parse("2022-12-06 07:40:15");
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<HonorFilePO> image = honorService.findImage(12);
        HonorFilePO PO = HonorFilePO.builder()
                .id(13)
                .honor_id(12)
                .file_name("档案")
                .file_path("http://www.patrickstarm.top:9090/pde-file/honor/75f3e591-22a4-4419-bd54-0df707fd93a1.png")
                .file_size(209599)
                .create_time(d)
                .enable_front(false).build();

        Assertions.assertEquals(PO, image.get(0));
    }

    @Test
    void findHonorAlbum() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date d = null;
        //这里会有一个异常，所以要用try catch捕获异常
        try {
            d = sdf.parse("2022-12-08 11:20:21");
        } catch (Exception e) {
            e.printStackTrace();
        }
        HonorVO build = HonorVO.builder()
                .id(12)
                .title("河北档案")
                .description("河北历史档案")
                .create_time(d)
                .enable_publish(true)
                .file_path("http://www.patrickstarm.top:9090/pde-file/honor/761450b7-a2a0-4269-b5b4-864fccbcfbd8.jpg")
                .build();
        List<HonorVO> VO = honorService.findHonorAlbum("河北");
        Assertions.assertEquals(build, VO.get(0));
    }

    @Test
    void publishHonor() {
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        PublishHonorDTO dto = PublishHonorDTO.builder()
                .enable_publish(true)
                .ids(ids).build();
        boolean res = honorService.publishHonor(dto);
        Assertions.assertTrue(res);
    }

    @Test
    void addImage() {
        HonorFileDTO dto = HonorFileDTO.builder()
                .honor_id(13)
                .file_name("单元测试")
                .file_path("http://www.patrickstarm.top:9090/pde-file/honor/75f3e591-22a4-4419-bd54-0df707fd93a1.png")
                .enable_front(true)
                .build();
        boolean res = honorService.addImage(dto);
        Assertions.assertTrue(res);
    }
    @Test
    void findPageImage() {
        HashMap<String, Object> pageImage = honorService.findPageImage(13, 1, 5);
        System.out.println(pageImage);
    }

    @Test
    void updateImage() {
        HonorFileDTO dto = HonorFileDTO.builder()
                .id(37)
                .honor_id(13)
                .file_name("单元测试")
                .file_path("http://www.patrickstarm.top:9090/pde-file/honor/75f3e591-22a4-4419-bd54-0df707fd93a1.png")
                .enable_front(true)
                .build();
        boolean res = honorService.updateImage(dto);
        Assertions.assertTrue(res);
    }

    @Test
    void removeImageById() {
        Integer[] ids = new Integer[1];
        ids[0] = 37;
        boolean res = honorService.removeImageById(ids);
        Assertions.assertTrue(res);
    }

    @Test
    void getCoverList() {
        PageInfo<HonorVO> coverList = honorService.getCoverList();
        System.out.println(coverList);
    }

    @Test
    void getPublishList() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date d = null;
        //这里会有一个异常，所以要用try catch捕获异常
        try {
            d = sdf.parse("2022-12-08 11:20:21");
        } catch (Exception e) {
            e.printStackTrace();
        }
        HonorVO build = HonorVO.builder()
                .id(12)
                .title("河北档案")
                .description("河北历史档案")
                .create_time(d)
                .enable_publish(true)
                .file_path("http://www.patrickstarm.top:9090/pde-file/honor/761450b7-a2a0-4269-b5b4-864fccbcfbd8.jpg")
                .build();
        List<HonorVO> res = honorService.getPublishList("河北");
        Assertions.assertEquals(build,res.get(0));

    }
}