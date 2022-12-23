package com.pde.pdes.portal.standard.controlller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pde.pdes.portal.Constants.Constants;
import com.pde.pdes.portal.company.po.CompanyPO;
import com.pde.pdes.portal.standard.dto.PageQuery;
import com.pde.pdes.portal.standard.dto.StandardDto;
import com.pde.pdes.portal.standard.po.Standard;
import com.pde.pdes.portal.standard.service.StandardService;
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
 * @author wangRich
 */
@RestController
@Api(tags = {"档案标准"})
@RequestMapping("/standard")
public class StandardController {

    @Autowired
    private StandardService standardService;

    @PostMapping("/add")
    @ApiOperation(value = "档案标准添加")
    public WebAsyncTask<SimpleResponse<?>> addStandard(@Valid @RequestBody StandardDto standardDto) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return standardService.add(standardDto) > 0 ? new SimpleResponse<>(true, "操作成功", "true") : new SimpleResponse<>(false, "操作成功", "false");
        });
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据standard的id删除")
    public WebAsyncTask<SimpleResponse<?>> removeStandardById(@PathVariable(name = "id", required = true) Integer id) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return standardService.deleteById(id) ? new SimpleResponse<>(true, "操作成功", "true") : new SimpleResponse<>(false, "操作成功", "false");
        });
    }

    @PostMapping("/deletes")
    @ApiOperation(value = "根据standard的id批量删除")
    public WebAsyncTask<SimpleResponse<?>> removeStandardByIds(@RequestBody List<Integer> ids) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return standardService.deleteByIds(ids) ? new SimpleResponse<>(true, "操作成功", "true") : new SimpleResponse<>(false, "操作成功", "false");
        });
    }

    @PostMapping("/upData")
    @ApiOperation(value = "standard更新")
    public WebAsyncTask<SimpleResponse<?>> upData(@Valid @RequestBody Standard standard) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return standardService.update(standard) ? new SimpleResponse<>(true, "操作成功", "true") : new SimpleResponse<>(false, "操作成功", "false");
        });
    }


    @PostMapping("/findAll")
    @ApiOperation(value = "获取Standard所有列表")
    public WebAsyncTask<SimpleResponse<?>> getStandardList(@RequestBody PageQuery query) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            Map<String, Object> map = new HashMap<String, Object>();
            Page<CompanyPO> page = PageHelper.startPage(query.getPageNum(), query.getPageSize(), true, false, false);
            if (query.getTitle().isEmpty()) {
                standardService.findAll();
            } else {
                standardService.getStandardByTitle(query.getTitle());
            }
            map.put("total", page.getTotal());
            map.put("rows", page.getResult());
            return new SimpleResponse<Object>(true, "操作成功", map);
        });
    }

    @PostMapping("/findShow")
    @ApiOperation(value = "获取Standard可展示列表")
    public WebAsyncTask<SimpleResponse<?>> getShowStandardList(@RequestBody PageQuery query) {
        return new WebAsyncTask<>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            Map<String, Object> map = new HashMap<String, Object>();
            Page<CompanyPO> page = PageHelper.startPage(query.getPageNum(), query.getPageSize(), true, false, false);
            if (query.getTitle().isEmpty()) {
                standardService.findShow();
            } else {
                standardService.getShowStandardByTitle(query.getTitle());
            }
            map.put("total", page.getTotal());
            map.put("rows", page.getResult());
            return new SimpleResponse<Object>(true, "操作成功", map);
        });
    }
}
