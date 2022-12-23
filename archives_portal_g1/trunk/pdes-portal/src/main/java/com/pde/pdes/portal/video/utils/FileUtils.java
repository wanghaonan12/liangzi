package com.pde.pdes.portal.video.utils;

import com.pde.pdes.portal.video.vo.FrontFileStream;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author: mth
 * @date: 2022/12/5
 * @description: 文件工具类
 */
@Component
@Configuration
public class FileUtils {
    private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

    /**
     * 随机获取视频截图
     *
     * @param video 视频文件
     * @param count 输出截图数量
     * @return 截图
     */
    public List<FrontFileStream> randomGrabberFfmpegImage(MultipartFile video, int count) throws Exception {
        File videFile = transferToFile(video);
        FFmpegFrameGrabber grabber = null;
        try {
            List<FrontFileStream> frontFileList = new ArrayList<>(count);
            grabber = new FFmpegFrameGrabber(videFile);
            grabber.start();
            /// 获取视频总帧数
            // int lengthInVideoFrames = grabber.getLengthInVideoFrames();
            // 获取视频时长， / 1000000 将单位转换为秒
            long delayedTime = grabber.getLengthInTime() / 1000000;
            Random random = new Random();
            for (int i = 0; i < count; i++) {
                // 跳转到响应时间
                grabber.setTimestamp((random.nextInt((int) delayedTime - 1) + 1) * 1000000L);
                Frame f = grabber.grabImage();
                Java2DFrameConverter converter = new Java2DFrameConverter();
                BufferedImage bi = converter.getBufferedImage(f);
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                ImageIO.write(bi, "jpg", os);
                InputStream inputStream = new ByteArrayInputStream(os.toByteArray());
                frontFileList.add(FrontFileStream.builder().fileSize(os.size()).inputStream(inputStream).build());
            }
            // 删除之前生成的临时文件
            videFile.delete();
            return frontFileList;
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            try {
                if (grabber != null) {
                    grabber.stop();
                    grabber.release();
                }
            } catch (FFmpegFrameGrabber.Exception e) {
                logger.error("getVideoInfo grabber.release failed 获取文件信息失败：{}", e.getMessage());
            }
        }
    }

    /**
     * MultipartFile 转 File 文件
     *
     * @param multipartFile MultipartFile类型
     * @return File类型
     */
    public static File transferToFile(MultipartFile multipartFile) {
        //选择用缓冲区来实现这个转换即使用java 创建的临时文件 使用 MultipartFile.transferTo()方法 。
        File file = null;
        try {
            String originalFilename = multipartFile.getOriginalFilename();
            assert originalFilename != null;
            //获取文件后缀
            String prefix = originalFilename.substring(originalFilename.lastIndexOf("."));
            /// String[] filename = originalFilename.split("\\.");
            // file = File.createTempFile(filename[0], filename[1]);
            //创建临时文件
            file = File.createTempFile(originalFilename, prefix);
            multipartFile.transferTo(file);

            ///在程序退出时删除
            file.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // return后删除
            // file.delete();
        }
        return file;
    }
}