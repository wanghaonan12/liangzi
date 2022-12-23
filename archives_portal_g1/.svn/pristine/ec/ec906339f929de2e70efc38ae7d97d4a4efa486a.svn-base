package com.pde.pdes.portal.video.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pde.pdes.portal.video.dto.VideoDTO;
import com.pde.pdes.portal.video.dto.VideoFileDTO;
import com.pde.pdes.portal.video.dto.VideoFileFrontDTO;
import com.pde.pdes.portal.video.dto.VideoQueryCondition;
import com.pde.pdes.portal.video.mapper.VideoFileFrontMapper;
import com.pde.pdes.portal.video.mapper.VideoFileMapper;
import com.pde.pdes.portal.video.mapper.VideoMapper;
import com.pde.pdes.portal.video.po.VideoFileFrontPO;
import com.pde.pdes.portal.video.po.VideoFilePO;
import com.pde.pdes.portal.video.po.VideoPO;
import com.pde.pdes.portal.video.vo.VideoFileFrontListVO;
import com.pde.pdes.portal.video.vo.VideoFileListVO;
import com.pde.pdes.portal.video.vo.portal.PortalFileVO;
import com.pde.pdes.portal.video.vo.portal.PortalVideoVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: mth
 * @date: 2022/12/21
 * @description: 视频专辑 video service 测试类
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
class VideoServiceTest {

    @Resource
    private VideoService videoService;

    @Resource
    private VideoMapper videoMapper;

    @Resource
    private VideoFileMapper videoFileMapper;

    @Resource
    private VideoFileFrontMapper videoFileFrontMapper;

    /**
     * 首页 视频档案列表
     */
    @Test
    void findPortalVideoList() {
        List<PortalVideoVO> portalVideoList = videoService.findPortalVideoList();
        System.out.println(portalVideoList);
        assertNotNull(portalVideoList);
    }

    /**
     * 首页 视频档案文件列表
     */
    @Test
    void findPortalVideoFileListByVideoId() {
        List<PortalFileVO> portalVideoFileList = videoService.findPortalVideoFileListByVideoId(7);
        System.out.println(portalVideoFileList);
        assertNotNull(portalVideoFileList);
    }

    /**
     * 分页模糊查询视频专辑
     */
    @Test
    void findByPage() {
        Map<String, Object> videoList = videoService.findByPage(VideoQueryCondition.builder().pageNum(1).pageSize(2).searchText("红").build());
        System.out.println(videoList);
        assertNotNull(videoList);
    }

    /**
     * 新增视频专辑
     */
    @Test
    void insert() {
        // 插入一条新记录
        Boolean insert = videoService.insert(VideoDTO.builder()
                .title("测试")
                .description("描述").build());
        System.out.println(insert);
        assertTrue(insert);
    }

    /**
     * 更新视频专辑
     */
    @Test
    void update() {
        // 刚好插入了新纪录可以作为修改测试，先获取刚插入的数据
        VideoPO videoPO = videoMapper.selectOne(new QueryWrapper<VideoPO>().eq("title", "测试").orderByDesc("create_time"));
        videoPO.setDescription("updated");
        Boolean update = videoService.update(videoPO);
        // 是否成功
        assertTrue(update);
        VideoPO updatedVideo = videoMapper.selectOne(new QueryWrapper<VideoPO>().eq("title", "测试").orderByDesc("create_time"));
        // 校验修改过的是否为刚才设置的updated
        assertEquals(updatedVideo.getDescription(), "updated");
        System.out.println(updatedVideo);
    }

    /**
     * 批量发布视频档案
     */
    @Test
    void enableByIds() {
        // 同理测试批量发布，实际上就是更新enable_publish为 1
        VideoPO videoPO = videoMapper.selectOne(new QueryWrapper<VideoPO>().eq("title", "测试").orderByDesc("create_time"));
        List<Integer> ids = new ArrayList<>();
        ids.add(videoPO.getId());
        Boolean enabled = videoService.enableByIds(ids);
        // 是否成功
        assertTrue(enabled);
        VideoPO updatedVideo = videoMapper.selectOne(new QueryWrapper<VideoPO>().eq("title", "测试").orderByDesc("create_time"));
        // 校验修改过的值是否正确
        assertEquals(updatedVideo.getEnable_publish(), 1);
        System.out.println(updatedVideo);
    }

    /**
     * 批量取消发布视频档案
     */
    @Test
    void disableByIds() {
        // 同理测试批量取消发布，实际上就是更新enable_publish为 0
        VideoPO videoPO = videoMapper.selectOne(new QueryWrapper<VideoPO>().eq("title", "测试").orderByDesc("create_time"));
        List<Integer> ids = new ArrayList<>();
        ids.add(videoPO.getId());
        Boolean disabled = videoService.disableByIds(ids);
        // 是否成功
        assertTrue(disabled);
        VideoPO updatedVideo = videoMapper.selectOne(new QueryWrapper<VideoPO>().eq("title", "测试").orderByDesc("create_time"));
        // 校验修改过的值是否正确
        assertEquals(updatedVideo.getEnable_publish(), 0);
        System.out.println(updatedVideo);
    }

    /**
     * 根据id查询视频专辑
     */
    @Test
    void findById() {
        // id为7是存在的
        VideoPO video = videoService.findById(7);
        System.out.println(video);
        assertNotNull(video);
    }

    /**
     * 根据文件id查询视频文件信息
     */
    @Test
    void findFileById() {
        // id为 12 是存在的
        VideoFileListVO videoFileList = videoService.findFileById(12);
        assertNotNull(videoFileList);
        System.out.println(videoFileList);
    }

    /**
     * 根据视频档案id查询视频列表
     */
    @Test
    void findByVideoId() {
        // id为7是存在的
        Map<String, Object> videoFiles = videoService.findByVideoId(7, 1, 1);
        assertNotNull(videoFiles);
        System.out.println(videoFiles);
    }

    /**
     * 视频档案新增视频文件
     */
    @Test
    void insertFile() {
        // 依然选择刚才新增的测试专辑
        VideoPO videoPO = videoMapper.selectOne(new QueryWrapper<VideoPO>().eq("title", "测试").orderByDesc("create_time"));
        // 新增结果的返回值是新纪录的id
        Integer newFileId = videoService.insertFile(VideoFileDTO.builder()
                .videoId(videoPO.getId())
                .fileName("测试文件")
                .filePath("http://xxx")
                .fileSize(1000).build());
        // 根据id查一下
        VideoFilePO newVideoFile = videoFileMapper.selectById(newFileId);
        // 校验是否为新增的测试文件
        assertEquals(newVideoFile.getFile_name(), "测试文件");
        // 因设置了专辑中的第一个视频文件为默认专辑封面，所以再校验is_front_file是否为 1 即为true
        assertEquals(newVideoFile.getIs_front_file(), true);
        System.out.println(newVideoFile);
    }

    /**
     * 根据id更新视频文件信息
     */
    @Test
    void updateFile() {
        // 获取最新插入的测试文件数据
        VideoFilePO videoFile = videoFileMapper.selectOne(new QueryWrapper<VideoFilePO>().eq("file_name", "测试文件").orderByDesc("create_time"));
        Boolean updated = videoService.updateFile(VideoFilePO.builder()
                .id(videoFile.getId())
                .file_path("http://updated").build());
        assertTrue(updated);
        // 因为使用了赋值转换，所以未更新的属性保留原样，下面是校验未更新的数据是否一致
        VideoFilePO updatedVideoFile = videoFileMapper.selectOne(new QueryWrapper<VideoFilePO>().eq("file_name", "测试文件").orderByDesc("create_time"));
        assertEquals(updatedVideoFile.getFile_name(), "测试文件");
        System.out.println(updatedVideoFile);
    }

    /**
     * 新增视频封面信息
     */
    @Test
    void insertFileFront() {
        VideoFilePO videoFile = videoFileMapper.selectOne(new QueryWrapper<VideoFilePO>().eq("file_name", "测试文件").orderByDesc("create_time"));
        List<VideoFileFrontDTO> frontList = new ArrayList<>();
        VideoFileFrontDTO dto = VideoFileFrontDTO.builder()
                .videoFileId(videoFile.getId())
                .fileName("测试封面")
                .filePath("http://test")
                .fileSize(100)
                .isFrontFile(false).build();
        frontList.add(dto);
        System.out.println(frontList);
        Boolean insert = videoService.insertFileFront(frontList);
        assertTrue(insert);
    }

    /**
     * 根据视频文件id查询封面列表
     */
    @Test
    void findFrontByVideoFileId() {
        VideoFilePO videoFile = videoFileMapper.selectOne(new QueryWrapper<VideoFilePO>().eq("file_name", "测试文件").orderByDesc("create_time"));
        List<VideoFileFrontListVO> frontList = videoService.findFrontByVideoFileId(videoFile.getId());
        System.out.println(frontList);
        assertNotNull(frontList);
    }

    /**
     * 设置视频文件封面
     */
    @Test
    void updateVideoFileByFront() {
        // 刚新增的文件
        VideoFilePO videoFile = videoFileMapper.selectOne(new QueryWrapper<VideoFilePO>().eq("file_name", "测试文件").orderByDesc("create_time"));
        // 找到刚新增的封面
        VideoFileFrontPO videoFileFront = videoFileFrontMapper.selectOne(new QueryWrapper<VideoFileFrontPO>().eq("file_name", "测试封面").orderByDesc("create_time"));
        // 设置封面
        Boolean setFront = videoService.updateVideoFileByFront(videoFile.getId(), videoFileFront.getId());
        assertTrue(setFront);
    }

    /**
     * 设置视频专辑的封面
     */
    @Test
    void updateVideoFrontByFile() {
        // 刚新增的视频专辑
        VideoPO videoPO = videoMapper.selectOne(new QueryWrapper<VideoPO>().eq("title", "测试").orderByDesc("create_time"));
        // 刚新增的文件
        VideoFilePO videoFile = videoFileMapper.selectOne(new QueryWrapper<VideoFilePO>().eq("file_name", "测试文件").orderByDesc("create_time"));
        // 设置专辑封面
        Boolean setVideoFront = videoService.updateVideoFrontByFile(videoPO.getId(), videoFile.getId());
        assertTrue(setVideoFront);
    }

    /**
     * 批量删除视频文件
     */
    @Test
    void delFileByIds() {
        List<Integer> ids = new ArrayList<>();
        VideoFilePO videoFile = videoFileMapper.selectOne(new QueryWrapper<VideoFilePO>().eq("file_name", "测试文件").orderByDesc("create_time"));
        ids.add(videoFile.getId());
        Integer del = videoService.delFileByIds(ids);
        assertTrue(del > 0);
    }

    /**
     * 根据ids批量删除视频专辑
     */
    @Test
    void delByIds() {
        List<Integer> ids = new ArrayList<>();
        // 最后，所有测试结束了，正好查询最新的那条刚好删除它以测试删除功能
        VideoPO videoPO = videoMapper.selectOne(new QueryWrapper<VideoPO>().eq("title", "测试").orderByDesc("create_time"));
        System.out.println(videoPO);
        ids.add(videoPO.getId());
        Integer del = videoService.delByIds(ids);
        assertTrue(del > 0);
    }
}