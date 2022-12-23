package com.pde.pdes.portal.news.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pde.pdes.portal.Constants.Constants;
import com.pde.pdes.portal.company.dto.QueryCondition;
import com.pde.pdes.portal.news.po.NewsFilePo;
import com.pde.pdes.portal.news.po.NewsPo;
import com.pde.pdes.portal.news.service.NewsFileService;
import com.pde.pdes.portal.news.util.FileUtil;
import com.pde.pdes.portal.utils.StringHelper;
import com.pde.pdes.portal.vo.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.util.*;

/**
 * 新闻附件接口
 * @author 沈建树
 */
@RestController
@Api(tags = {"新闻附件服务"})
@RequestMapping("/newsFile")
public class NewsFileController {
    @Resource
    NewsFileService newsFileService;

    @PostMapping("/upload")
    @ApiOperation("上传新闻附件")
    public WebAsyncTask<SimpleResponse<Boolean>> upload(MultipartFile[] files,Integer newsId) {
        return new WebAsyncTask<>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            boolean flag = false;
            for (MultipartFile file : files) {
                String fileName = StringHelper.getPrimaryKey() + "_" + file.getOriginalFilename();
                String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
                String path = "/users/jarvizshen/downloads/newsFile" + FileUtil.getFilePath(suffix);
                file.transferTo(new File(path, fileName));
                flag = newsFileService.addFile(NewsFilePo.builder()
                        .newsId(newsId)
                        .fileName(file.getOriginalFilename())
                        .filePath(path)
                        .fileSize((int) (file.getSize() / 1024))
                        .fileSuffix(fileName.substring(fileName.lastIndexOf(".")+1))
                        .orderSeq(new Random().nextInt()).build());
            }
            if (flag) {
                return new SimpleResponse<>(true, "上传成功");
            } else {
                return new SimpleResponse<>(false, "上传失败");
            }
        });
    }

    @PostMapping("/find")
    @ApiOperation("获取新闻附件列表")
    public WebAsyncTask<SimpleResponse<Map<String, Object>>> find(@RequestBody QueryCondition query) {
        return new WebAsyncTask<>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            Map<String, Object> map = new HashMap<>(2);
            try (Page<NewsFilePo> page = PageHelper.startPage(query.getPageNum(), query.getPageSize(), true, false, false)) {
                newsFileService.getFiles(query.getSearchText());
                map.put("total", page.getTotal());
                map.put("rows", page.getResult());
            }
            return new SimpleResponse<>(true, "操作成功", map);
        });
    }

    @GetMapping("/findByNewsId")
    @ApiOperation("根据新闻ID获取新闻附件列表")
    public WebAsyncTask<SimpleResponse<?>> findById(Integer newsId) {
        return new WebAsyncTask<>(30 * 1000L, Constants.EXECUTOR_NAME, () -> new SimpleResponse<>(true,"操作成功",newsFileService.getFilesByNewsId(newsId)));
    }

    @PostMapping("/add")
    @ApiOperation("添加新闻附件")
    public WebAsyncTask<SimpleResponse<Boolean>> add(@RequestBody NewsFilePo newsFilePo) {
        return new WebAsyncTask<>(30 * 1000L, Constants.EXECUTOR_NAME, () -> new SimpleResponse<>(newsFileService.addFile(newsFilePo)));
    }

    @DeleteMapping("/delete")
    @ApiOperation("根据ID删除新闻附件")
    public WebAsyncTask<SimpleResponse<Boolean>> delete(Integer id) {
        return new WebAsyncTask<>(30 * 1000L, Constants.EXECUTOR_NAME, () -> new SimpleResponse < > (newsFileService.deleteFileById(id)));
    }
}
