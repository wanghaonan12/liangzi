package com.pde.pdes.portal.annals.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pde.pdes.portal.Constants.Constants;
import com.pde.pdes.portal.annals.dto.AnnalsDTO;
import com.pde.pdes.portal.annals.dto.AnnalsFileDTO;
import com.pde.pdes.portal.annals.dto.AnnalsQueryCondition;
import com.pde.pdes.portal.annals.po.AnnalsFilePO;
import com.pde.pdes.portal.annals.po.AnnalsPO;
import com.pde.pdes.portal.annals.service.AnnalsFileService;
import com.pde.pdes.portal.annals.service.AnnalsService;
import com.pde.pdes.portal.vo.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jtt
 */
@RestController
@Api(tags = {"年鉴档案服务"})
@RequestMapping("/annals")
public class AnnalsController {
    @Autowired
    private AnnalsService annalsService;
    @Autowired
    private AnnalsFileService annalsFileService;

    @GetMapping
    @ApiOperation(value = "分页模糊查询年鉴档案列表")
    public WebAsyncTask<SimpleResponse<?>> getList(@RequestParam(required = false, defaultValue = "1") int pageNum,
                                                   @RequestParam(required = false, defaultValue = "10") int pageSize,
                                                   @RequestParam(required = false) String searchText) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            AnnalsQueryCondition query = AnnalsQueryCondition.builder().pageNum(pageNum).pageSize(pageSize).searchText(searchText).build();
            Map<String, Object> map = new HashMap<String, Object>();
            Page<AnnalsPO> page = PageHelper.startPage(query.getPageNum(), query.getPageSize(), true, false, false);
            annalsService.findByPage(query);
            map.put("data", page.getResult());
            map.put("total", page.getTotal());
            return new SimpleResponse<Object>(true, "操作成功", map);
        });
    }

    @GetMapping("/id")
    @ApiOperation(value = "根据id获取年鉴档案信息")
    public WebAsyncTask<SimpleResponse<?>> getAnnalsById(@RequestParam() Integer id) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            AnnalsPO annals = annalsService.findById(id);
            return new SimpleResponse<Object>(true, "操作成功", annals);
        });
    }

    @GetMapping("/file/id")
    @ApiOperation(value = "根据id获取年鉴档案信息")
    public WebAsyncTask<SimpleResponse<?>> getAnnalsFileById(@RequestParam() Integer id) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            AnnalsFilePO annalsFile = annalsFileService.findById(id);
            return new SimpleResponse<Object>(true, "操作成功", annalsFile);
        });
    }

    @GetMapping("/file")
    @ApiOperation(value = "根据视频档案id查询年鉴文件")
    public WebAsyncTask<SimpleResponse<?>> getFilesByAnnalsId(@RequestParam Integer annalsid) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            List<AnnalsFilePO> videoFileList = annalsFileService.findByAnnalsId(annalsid);
            return new SimpleResponse<Object>(true, "操作成功", videoFileList);
        });
    }

    @PostMapping
    @ApiOperation(value = "新增年鉴档案")
    public WebAsyncTask<SimpleResponse<?>> add(@Valid @RequestBody AnnalsDTO dto) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<>(annalsService.insert(dto));
        });
    }

    @PostMapping(value = "/file")
    @ApiOperation(value = "新增年鉴文件")
    public WebAsyncTask<SimpleResponse<?>> addFile(@Valid @RequestBody AnnalsFileDTO dto) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<>(annalsFileService.insert(dto));
        });
    }

    @PutMapping(value = "/enable")
    @ApiOperation(value = "批量发布年鉴档案")
    public WebAsyncTask<SimpleResponse<?>> enableByIds(@Valid @RequestBody List<Integer> ids) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<>(annalsService.enableByIds(ids));
        });
    }

    @PutMapping(value = "/disable")
    @ApiOperation(value = "批量取消发布年鉴档案")
    public WebAsyncTask<SimpleResponse<?>> disableByIds(@Valid @RequestBody List<Integer> ids) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<>(annalsService.disableByIds(ids));
        });
    }

    @PutMapping(value = "/update")
    @ApiOperation(value = "修改年鉴档案信息")
    public WebAsyncTask<SimpleResponse<?>> updateAnnals(@Valid @RequestBody AnnalsPO po) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<>(annalsService.update(po));
        });
    }

    @PutMapping(value = "/file/update")
    @ApiOperation(value = "修改年鉴文件信息")
    public WebAsyncTask<SimpleResponse<?>> updateVideoFile(@Valid @RequestBody AnnalsFilePO po) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<>(annalsFileService.update(po));
        });
    }
}
