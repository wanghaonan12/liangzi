package com.pde.pdes.portal.chronicle.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pde.pdes.portal.Constants.Constants;
import com.pde.pdes.portal.chronicle.dto.PdesPortalChronicleEventsFileDto;
import com.pde.pdes.portal.chronicle.dto.PublishDto;
import com.pde.pdes.portal.chronicle.po.PdesPortalChronicleEventsFile;
import com.pde.pdes.portal.chronicle.service.PdesPortalChronicleEventsFileService;

import com.pde.pdes.portal.company.dto.QueryCondition;
import com.pde.pdes.portal.company.po.CompanyPO;
import com.pde.pdes.portal.vo.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.WebAsyncTask;
import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SYKCOMPUTER
 */
@RestController
@Api(tags = {"档案大事记附件Api"})
@RequestMapping("/")
public class PdesPortalChronicleEventsFileController {
    @Resource
    private PdesPortalChronicleEventsFileService pdesPortalChronicleEventsFileService;

    @PostMapping("chronicle/adjust/add")
    @ApiOperation(value = "添加大事记附件附件")
    public WebAsyncTask<SimpleResponse<?>> add(@Valid @RequestBody PdesPortalChronicleEventsFileDto po) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Boolean>(pdesPortalChronicleEventsFileService.add(po));
        });
    }

    @DeleteMapping("chronicle/adjust/{id}")
    @ApiOperation(value = "删除大事记附件")
    public WebAsyncTask<SimpleResponse<?>> removeById(@PathVariable(name = "id", required = true) String id) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Boolean>(pdesPortalChronicleEventsFileService.deleteById(id));
        });
    }

    @DeleteMapping("chronicle/adjust/deleteByIds")
    @ApiOperation(value = "批量删除大事记附件")
    public WebAsyncTask<SimpleResponse<?>> removeById(@RequestParam(name = "ids", required = true) List<Integer> ids) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Boolean>(pdesPortalChronicleEventsFileService.deleteByIds(ids));
        });
    }


    @GetMapping("v1/chronicle/adjust/{id}")
    @ApiOperation(value = "根据ID获取大事记附件")
    public WebAsyncTask<SimpleResponse<?>> findById(@PathVariable(name = "id", required = true) String id) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<PdesPortalChronicleEventsFile>(pdesPortalChronicleEventsFileService.findById(id));
        });
    }
    @GetMapping("v1/chronicle/adjust/file/{chronicleId}")
    @ApiOperation(value = "根据ID获取大事记附件")
    public WebAsyncTask<SimpleResponse<?>> findByChronicleId(@PathVariable(name = "chronicleId", required = true) Integer chronicleId) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<List<PdesPortalChronicleEventsFile>>(pdesPortalChronicleEventsFileService.findByChronicleId(chronicleId));

        });
    }
    @PostMapping("v1/chronicle/adjust/find")
    @ApiOperation(value = "获取大事记附件列表")
    public WebAsyncTask<SimpleResponse<?>> getList(@RequestBody QueryCondition query) {
        return new WebAsyncTask<>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            Map<String, Object> map = new HashMap<String, Object>();
            Page<CompanyPO> page = PageHelper.startPage(query.getPageNum(), query.getPageSize(), true, false, false);
            pdesPortalChronicleEventsFileService.find(query.getSearchText());
            map.put("total", page.getTotal());
            map.put("rows", page.getResult());
            return new SimpleResponse<Object>(true, "操作成功", map);
        });
    }

    @PostMapping("chronicle/adjust/top")
    @ApiOperation(value = "置顶大事记附件")
    public WebAsyncTask<SimpleResponse<?>> publishByIds(@RequestBody(required = true) PublishDto publishDto) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Boolean>(pdesPortalChronicleEventsFileService.isTop(publishDto.getOrderSeq(),publishDto.getIds()));
        });
    }

    @PostMapping("chronicle/adjust/update")
    @ApiOperation(value = "编辑大事记附件")
    public WebAsyncTask<SimpleResponse<?>> updateEvent(@RequestBody PdesPortalChronicleEventsFile pdeEvent) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<PdesPortalChronicleEventsFile>(pdesPortalChronicleEventsFileService.updateEvent(pdeEvent));
        });
    }
}
