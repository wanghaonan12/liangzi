package com.pde.pdes.portal.standard.controlller;

import com.pde.pdes.portal.Constants.Constants;
import com.pde.pdes.portal.standard.po.StandardFile;
import com.pde.pdes.portal.standard.service.StandardFileService;
import com.pde.pdes.portal.standard.utils.AliYunOssClientUtils;
import com.pde.pdes.portal.vo.AddStandardFileVo;
import com.pde.pdes.portal.vo.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.validation.Valid;
import java.util.List;

/**
 * @author wangRich
 */
@RestController
@Api(tags = {"档案标准文件"})
@RequestMapping("/standardFile")
public class StandardFileController {

    @Autowired
    private StandardFileService standardFileService;

    @PostMapping("/add")
    @ApiOperation(value = "档案标准文件添加")
        public WebAsyncTask<SimpleResponse<?>> addStandard(AddStandardFileVo addStandardFileVo
    ) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return standardFileService.add(addStandardFileVo.getFile(), addStandardFileVo.getTitle(),Integer.parseInt(addStandardFileVo.getStandardId()) )>0? new SimpleResponse<>(true,"操作成功","true") :  new SimpleResponse<>(false,"操作成功","false");
        });
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "根据档案标准文件的id删除")
    public WebAsyncTask<SimpleResponse<?>> removeStandardById(@PathVariable(name = "id", required = true) Integer id) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return standardFileService.deleteById(id)? new SimpleResponse<>(true,"操作成功","true") :  new SimpleResponse<>(false,"操作成功","false");
        });
    }

    @PostMapping("/upData/")
    @ApiOperation(value = "standardFile更新")
    public WebAsyncTask<SimpleResponse<?>> upData(@Valid @RequestBody StandardFile standardFile) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return standardFileService.update(standardFile) ?new SimpleResponse<>(true,"操作成功","true") :  new SimpleResponse<>(false,"操作成功","false");
        });
    }

    @GetMapping("/getFileByStandardId/{id}")
    @ApiOperation(value = "根据standardID获取StandardFile")
    public WebAsyncTask<SimpleResponse<?>> findStandardById(@PathVariable(name = "id", required = true) Integer id) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<List<StandardFile>>(standardFileService.getFileByStandardId(id));
        });
    }
}
