package com.pde.pdes.portal.honor.utils;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @Author chl
 * @Description 获取文件大小工具类
 * @Date 2022/12/10 11:38
 * @Version 1.0
 */
public class GetResourceLengthUtils {

    /**
     * 给定url地址获取资源的大小（以字节为单位）
     * @param urlStr 文件路径
     * @return 转换结果
     * @throws IOException io异常
     */
    public static long getResourceLength(String urlStr) throws IOException {
        URL url=new URL(urlStr);
        URLConnection urlConnection=url.openConnection();
        urlConnection.connect();
        //返回响应报文头字段Content-Length的值
        return urlConnection.getContentLength();
    }

}
