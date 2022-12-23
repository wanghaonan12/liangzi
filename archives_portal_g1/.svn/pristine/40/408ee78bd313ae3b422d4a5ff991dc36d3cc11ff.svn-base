package com.pde.pdes.portal.honor.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pde.pdes.portal.Constants.Constants;
import com.pde.pdes.portal.chronicle.dto.PublishDto;
import com.pde.pdes.portal.honor.dto.HonorDTO;
import com.pde.pdes.portal.honor.dto.HonorFileDTO;
import com.pde.pdes.portal.honor.dto.PublishHonorDTO;
import com.pde.pdes.portal.honor.dto.QueryDTO;
import com.pde.pdes.portal.honor.po.HonorFilePO;
import com.pde.pdes.portal.honor.service.HonorService;
import com.pde.pdes.portal.honor.vo.HonorVO;
import com.pde.pdes.portal.vo.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

/**
 * @Author chl
 * @Description 荣誉档案接口
 * @Date 2022/12/10 11:35
 * @Version 1.0
 */

@RestController
@Api(tags = {"荣誉档案相册服务"})
@RequestMapping("/")
public class HonorController {


    @Autowired
    private HonorService honorService;


    @PostMapping("/honor/add")
    @ApiOperation(value = "添加相册")
    public WebAsyncTask<SimpleResponse<?>> add(@Valid @RequestBody HonorDTO dto) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Boolean>(honorService.addHonor(dto));
        });
    }

    @DeleteMapping("/honor/remove")
    @ApiOperation(value = "批量删除相册")
    public WebAsyncTask<SimpleResponse<?>> removeById(@Valid @RequestBody Integer[] ids) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Boolean>(honorService.removeById(ids), "删除成功");
        });
    }

    @PutMapping("/honor/publish")
    @ApiOperation(value = "批量操作发布相册")
    public WebAsyncTask<SimpleResponse<?>> publishHonor(@Valid @RequestBody PublishHonorDTO dto) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Boolean>(honorService.publishHonor(dto), "修改成功");
        });
    }
    @PutMapping("/honor/update")
    @ApiOperation(value = "修改相册")
    public WebAsyncTask<SimpleResponse<?>> update(@Valid @RequestBody HonorDTO dto) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Boolean>(honorService.update(dto), "修改成功");
        });
    }

    @PostMapping("/honor/get")
    @ApiOperation(value = "模糊查询所有相册")
    public WebAsyncTask<SimpleResponse<?>> getList(@RequestBody QueryDTO queryDTO) {
        System.out.println(queryDTO);
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            try {
                //1、调用PageHelper的startPage方法设置参数,其中第一项为当前页，第二项为每页显示条数
                PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
                //2、调用Mapper层查询的方法
                List<HonorVO> all = honorService.findHonorAlbum(queryDTO.getTitle());
                PageInfo<HonorVO> honorPoPageInfo = new PageInfo<>(all);
                return new SimpleResponse<PageInfo<HonorVO>>(honorPoPageInfo);
            } finally {
                PageHelper.clearPage(); //清理 ThreadLocal 存储的分页参数,保证线程安全
            }
        });
    }

    @PostMapping("/v1/honor/get")
    @ApiOperation(value = "模糊查询发布相册")
    public WebAsyncTask<SimpleResponse<?>> getPublishList(@RequestBody QueryDTO queryDTO) {
        System.out.println(queryDTO);
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            try {
                //1、调用PageHelper的startPage方法设置参数,其中第一项为当前页，第二项为每页显示条数
                PageHelper.startPage(queryDTO.getPageNum(), queryDTO.getPageSize());
                //2、调用Mapper层查询的方法
                List<HonorVO> all = honorService.getPublishList(queryDTO.getTitle());
                PageInfo<HonorVO> honorPoPageInfo = new PageInfo<>(all);
                return new SimpleResponse<PageInfo<HonorVO>>(honorPoPageInfo);
            } finally {
                PageHelper.clearPage(); //清理 ThreadLocal 存储的分页参数,保证线程安全
            }
        });
    }

    @GetMapping("/v1/honor/homepage")
    @ApiOperation(value = "查询首页展示相册")
    public WebAsyncTask<SimpleResponse<?>> getCoverList() {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            PageInfo<HonorVO> coverList = honorService.getCoverList();
            return new SimpleResponse<PageInfo<HonorVO>>(coverList);

        });
    }

    @PostMapping("/honorImage/add")
    @ApiOperation(value = "添加图片")
    public WebAsyncTask<SimpleResponse<?>> addImage(@Valid @RequestBody HonorFileDTO dto) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Boolean>(honorService.addImage(dto), "添加成功");
        });
    }

    @DeleteMapping("/honorImage/remove")
    @ApiOperation(value = "批量删除相册图片")
    public WebAsyncTask<SimpleResponse<?>> removeImageById(@Valid @RequestBody Integer[] ids) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Boolean>(honorService.removeImageById(ids), "删除成功");
        });
    }

    @PutMapping("/honorImage/update")
    @ApiOperation(value = "修改相册图片")
    public WebAsyncTask<SimpleResponse<?>> updateImage(@Valid @RequestBody HonorFileDTO dto) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Boolean>(honorService.updateImage(dto), "修改成功");
        });
    }

    @GetMapping("/v1/honorImage/get")
    @ApiOperation(value = "分页查询相册图片列表")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "honorId", value = "相册id"),
                    @ApiImplicitParam(name = "pageIndex", value = "页码"),
                    @ApiImplicitParam(name = "pageSize", value = "每页数量")
            }
    )

    public WebAsyncTask<SimpleResponse<?>> getPageImageList(@Valid @RequestParam Integer honorId,
                                                            @RequestParam(defaultValue = "1") Integer pageIndex,
                                                            @RequestParam(defaultValue = "5") Integer pageSize) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {

            HashMap<String, Object> map = honorService.findPageImage(honorId, pageIndex, pageSize);

            return new SimpleResponse<Object>(true,"操作成功",map);
        });
    }

    @GetMapping("/honorImage/get")
    @ApiOperation(value = "查询相册图片列表（不分页）")
    @ApiImplicitParam(name = "honorId", value = "相册id")
    public WebAsyncTask<SimpleResponse<?>> getImageList(@Valid @RequestParam Integer honorId) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            List<HonorFilePO> honorFilePoS = honorService.findImage(honorId);
            return new SimpleResponse<List<HonorFilePO>>(honorFilePoS);
        });
    }
}
