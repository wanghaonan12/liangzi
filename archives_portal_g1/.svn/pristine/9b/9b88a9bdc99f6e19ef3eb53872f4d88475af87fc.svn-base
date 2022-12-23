package com.pde.pdes.portal.standard.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.DeleteObjectsRequest;
import com.aliyun.oss.model.DeleteObjectsResult;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 阿里云oss存储工具类
 *
 * @author : WangRich
 * @description : 实现了阿里云存储桶的文件存储删除等操作
 * @date : 2022/12/7 11:36
 */

@Component
@Data
@Slf4j
public class AliYunOssClientUtils {

    @Value("${oss.endPoint}")
    private String endpoint;

    @Value("${oss.accessKeyId}")
    private String accessKeyId;

    @Value("${oss.accessKeySecret}")
    private String accessKeySecret;
    @Value("${oss.bucketName}")
    private String bucketName;

    OSSClient ossClient;

    public AliYunOssClientUtils() {
    }

    @PostConstruct
    public void init() {
        ossClient = new OSSClient("https://" + endpoint, accessKeyId, accessKeySecret);
    }


    /**
     * 上传到oss
     *
     * @param file 需要上传的文件
     * @param parentFileName 上层目录名【评审安排/造价文件】
     * @return 保存好的文件名称
     */
    @Transactional(rollbackFor = Exception.class)
    public String uploadObjectOss(File file, String parentFileName) {
        Date parentDateTime = new Date();
        String yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd").format(parentDateTime);
        String hhMMss = new SimpleDateFormat("HH:mm:ss").format(parentDateTime);
        String fileName = parentFileName + "/" + yyyyMMdd + "/" + hhMMss + "/" + file.getName().replace("+", "");
        String path = "https://" + bucketName + "." + endpoint + "/" + fileName;
        try {
            init();
            log.info("图片路径："+path);
            InputStream inputStream = new FileInputStream(file);
            ossClient.putObject(bucketName, fileName, inputStream);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return path;
    }

    /**
     *  oss文件删除
     *
     * @param keys 传入多个需要删除的文件路径不包括bucketName
     */
    @Transactional(rollbackFor = Exception.class)
    public void removeObjectBatch(List<String> keys) {
        if(!keys.isEmpty()){
            try {
                DeleteObjectsResult deleteObjectsResult = ossClient.deleteObjects(new DeleteObjectsRequest(bucketName).withKeys(keys).withEncodingType("url"));
                List<String> deletedObjects = deleteObjectsResult.getDeletedObjects();
                try {
                    for(String obj : deletedObjects) {
                        String deleteObj =  URLDecoder.decode(obj, "UTF-8");
                        System.out.println(deleteObj);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            } catch (OSSException oe) {
                log.info("Caught an OSSException, which means your request made it to OSS, "
                        + "but was rejected with an error response for some reason.");
                log.info("Error Message:" + oe.getErrorMessage());
                log.info("Error Code:" + oe.getErrorCode());
                log.info("Request ID:" + oe.getRequestId());
                log.info("Host ID:" + oe.getHostId());
                throw new RuntimeException("AliYunOssClientUtils类removeObjectBatch方法发生异常执行回滚");
            } finally {
                if (ossClient != null) {
                    ossClient.shutdown();
                }
            }
        }else {
            return;
        }
    }

    /**
     * 对于文件的删除
     *
     * @param fileName 文件名
     */
    public void removeObject(String fileName) {
        try {
            // 删除文件或目录。如果要删除目录，目录必须为空。
            init();
            ossClient.deleteObject(bucketName, fileName);
        } catch (OSSException e) {
            throw new RuntimeException(e);
        } catch (ClientException e) {
            throw new RuntimeException(e);
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}

