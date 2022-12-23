package com.pde.pdes.portal.archive.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pde.pdes.portal.Constants.Constants;
import com.pde.pdes.portal.archive.dao.ArchiveFileAddDao;
import com.pde.pdes.portal.archive.dao.ArchiveFileUpdateDao;
import com.pde.pdes.portal.archive.po.ArchiveFilePo;
import com.pde.pdes.portal.archive.service.ArchiveFlieService;
import com.pde.pdes.portal.archive.service.ArchiveService;
import com.pde.pdes.portal.company.dto.QueryCondition;
import com.pde.pdes.portal.vo.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaozp
 * @date 2022-12-21 19：00
 */

@Api(tags = {"开发档案文件服务"})
@RequestMapping("/")
@RestController
@Slf4j
public class ArchiveFileController {

    @Resource
    private ArchiveService pdesPortalPublicArchiveService;

    @Resource
    private ArchiveFlieService pdesPortalPublicArchiveFileService;

    /**
     * @Title 查询所有内容，分页，每页8条
     * @param query
     * @return WebAsyncTask<SimpleResponse<Object>>
     */
    @GetMapping("v1/archiveFile/findList")
    @ApiOperation(value = "查询所有内容，分页，每页8条")
    public WebAsyncTask<SimpleResponse<?>> selectAll(@RequestBody QueryCondition query) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            Map<String, Object> map = new HashMap<String, Object>();
            Page<ArchiveFilePo> page = PageHelper.startPage(query.getPageNum(), query.getPageSize(), true, false, false);
            pdesPortalPublicArchiveFileService.selectAll(query.getSearchText());
            map.put("total", page.getTotal());
            map.put("rows", page.getResult());
            return new SimpleResponse<Object>(true, "操作成功", map);
        });
    }

    /**
     * @Title 查询单条内容
     * @param id
     * @return WebAsyncTask<SimpleResponse<Object>>
     */
    @GetMapping("v1/archiveFile/findById/{id}")
    @ApiOperation(value = "根据id查询单条内容")
    public WebAsyncTask<SimpleResponse<?>> findById(@PathVariable Integer id) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<ArchiveFilePo>(pdesPortalPublicArchiveFileService.selectById(id));
        });
    }

    /**
     * @Title 修改条目信息
     * @param archiveFileUpdateDao
     * @return WebAsyncTask<SimpleResponse<Integer>>
     */
    @PostMapping("archiveFile/update")
    @ApiOperation(value = "根据id修改文件")
    public WebAsyncTask<SimpleResponse<?>> update(@RequestBody ArchiveFileUpdateDao archiveFileUpdateDao) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Integer>(pdesPortalPublicArchiveFileService.update(archiveFileUpdateDao));
        });
    }

    /**
     * @Title 单个删除
     * @param id
     * @return WebAsyncTask<SimpleResponse<Boolean>>
     */
    @GetMapping("archiveFile/del/{id}")
    @ApiOperation(value = "根据id删除单个条目")
    public WebAsyncTask<SimpleResponse<?>> del(@PathVariable Integer id) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Boolean>(pdesPortalPublicArchiveFileService.del(id));
        });
    }

    /**
     * @Title 批量删除
     * @param list
     * @return WebAsyncTask<SimpleResponse<Integer>>
     */
    @PostMapping("archiveFile/delList")
    @ApiOperation(value = "根据id批量删除")
    public WebAsyncTask<SimpleResponse<?>> delList(@RequestBody Integer[] list) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Integer>(pdesPortalPublicArchiveService.delList(list));
        });
    }

    /**
     * @Title 插入
     * @param archiveFileAddDao
     * @return WebAsyncTask<SimpleResponse<Integer>>
     */
    @PostMapping("archiveFile/insert")
    @ApiOperation(value = "插入")
    public WebAsyncTask<SimpleResponse<?>> insert(@RequestBody ArchiveFileAddDao archiveFileAddDao) {
        System.out.println(archiveFileAddDao);
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Integer>(pdesPortalPublicArchiveFileService.add(archiveFileAddDao));
        });
    }
}
