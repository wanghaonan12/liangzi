package com.pde.pdes.portal.news.util;

/**
 * 存储工具类
 * @author 沈建树
 */
public class FileUtil {
    public static String getFilePath(String suffix) {
        String jpg = "jpg";
        String jpeg = "jpeg";
        String png = "png";
        String mp4 = "mp4";
        String mov = "mov";
        String avi = "avi";
        String doc = "doc";
        String docx = "docx";
        String pdf = "pdf";
        String xls = "xls";
        String xlsx = "xlsx";
        if (jpg.equals(suffix) || jpeg.equals(suffix) || png.equals(suffix)) {
            return "/images";
        } else if (mp4.equals(suffix) || mov.equals(suffix) || avi.equals(suffix)) {
            return "/videos";
        } else if (doc.equals(suffix) || docx.equals(suffix) || pdf.equals(suffix) || xls.equals(suffix) || xlsx.equals(suffix)) {
            return "/docs";
        } else {
            return "/other";
        }
    }
}
