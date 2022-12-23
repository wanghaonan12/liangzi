package com.pde.pdes.portal.photo.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pde.pdes.portal.Constants.Constants;
import com.pde.pdes.portal.company.dto.CompanyDTO;
import com.pde.pdes.portal.company.po.CompanyPO;
import com.pde.pdes.portal.honor.dto.HonorDTO;
import com.pde.pdes.portal.photo.dto.FileQueryCondition;
import com.pde.pdes.portal.photo.dto.PhotoDTO;
import com.pde.pdes.portal.photo.dto.PhotoFileDTO;
import com.pde.pdes.portal.photo.dto.QueryCondition;
import com.pde.pdes.portal.photo.po.PhotoFilePO;
import com.pde.pdes.portal.photo.po.PhotoPO;
import com.pde.pdes.portal.photo.service.PhotoFileService;
import com.pde.pdes.portal.photo.service.PhotoService;
import com.pde.pdes.portal.photo.vo.PhotoFileVO;
import com.pde.pdes.portal.photo.vo.PhotoVO;
import com.pde.pdes.portal.vo.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = {"照片专题"})
@RequestMapping
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @PostMapping("/photo/add")
    @ApiOperation(value = "增")
    public WebAsyncTask<SimpleResponse<?>> add(@Valid @RequestBody PhotoDTO dto) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Boolean>(photoService.add(dto));
        });
    }

    @DeleteMapping("/photo/delete")
    @ApiOperation(value = "删")
    public WebAsyncTask<SimpleResponse<?>> removeById(@Valid @RequestBody List<Integer> id) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Boolean>(photoService.deleteByIds(id),"删除成功");
        });
    }

    @PutMapping("/photo/update")
    @ApiOperation(value = "改")
    public WebAsyncTask<SimpleResponse<?>> update(@Valid @RequestBody PhotoPO po) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Boolean>(photoService.update(po),"修改成功");
        });
    }

    @GetMapping("/photo/{id}")
    @ApiOperation(value = "根据id获取照片信息")
    public WebAsyncTask<SimpleResponse<?>> findById(@PathVariable(name = "id", required = true) String id) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<PhotoPO>(photoService.findById(id));
        });
    }

    @PostMapping("/v1/photo/getPhotoList")
    @ApiOperation(value = "根据title获取图片列表")
    public WebAsyncTask<SimpleResponse<?>> getList(@RequestBody QueryCondition query) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            Map<String, Object> map = new HashMap<String, Object>();
            Page<PhotoPO> page = PageHelper.startPage(query.getPageNum(), query.getPageSize(), true, false, false);
            photoService.find(query.getTitle());
            map.put("total", page.getTotal());
            map.put("rows", page.getResult());
            return new SimpleResponse<Object>(true, "操作成功", map);
        });
    }

    @Autowired
    private PhotoFileService photoFileService;

    @PostMapping("/photoFile/add")
    @ApiOperation(value="增")
    public WebAsyncTask<SimpleResponse<?>> addPhoto(@Valid @RequestBody PhotoFileDTO dto) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Boolean>(photoFileService.add(dto));
        });
    }

    @DeleteMapping("/photoFile/delete")
    @ApiOperation(value = "删")
    public WebAsyncTask<SimpleResponse<?>> removePhotoById(@PathVariable(name = "id", required = true) List<Integer> ids) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Boolean>(photoFileService.deleteByIds(ids));
        });
    }

    @PutMapping("/photoFile/update")
    @ApiOperation(value = "改")
    public WebAsyncTask<SimpleResponse<?>> updatePhoto(@Valid @RequestBody PhotoFilePO po) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Boolean>(photoFileService.update(po),"修改成功");
        });
    }

    @GetMapping("/photoFile/{id}")
    @ApiOperation(value = "根据id获取照片信息")
    public WebAsyncTask<SimpleResponse<?>> findPhotoById(@PathVariable(name = "id", required = true) String id) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<PhotoFilePO>(photoFileService.findById(id));
        });
    }

    @PostMapping("/v1/photoFile/getPhotoFileList")
    @ApiOperation(value = "根据title获取图片列表")
    public WebAsyncTask<SimpleResponse<?>> getPhotoList(@RequestBody FileQueryCondition query) {
        System.out.println(query.toString());
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            Map<String, Object> map = new HashMap<String, Object>();
            Page<PhotoFilePO> page = PageHelper.startPage(query.getPageNum(), query.getPageSize(), true, false, false);
            System.out.println(query.getPhotoId());
            List<PhotoFileVO> photoFileVOS = photoFileService.find(query.getPhotoId());
            map.put("total", page.getTotal());
            map.put("rows", photoFileVOS);
            return new SimpleResponse<Object>(true, "操作成功", map);
        });
    }

    @PutMapping("/photo/cancelPublished")
    @ApiOperation(value = " 取消发布")
    public WebAsyncTask<SimpleResponse<?>> cancelPublished(@Valid @RequestBody List<Integer> ids) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Boolean>(photoService.cancelPublished(ids),"取消成功");
        });
    }

    @PutMapping("/photo/toPublished")
    @ApiOperation(value = " 发布")
    public WebAsyncTask<SimpleResponse<?>> toPublished(@Valid @RequestBody List<Integer> ids) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Boolean>(photoService.toPublished(ids),"发布成功");
        });
    }

    @PutMapping("/photoFile/setFront")
    @ApiOperation(value = "设为封面")
    public WebAsyncTask<SimpleResponse<?>> setFront(@Valid @RequestParam Integer id) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Boolean>(photoFileService.setFront(id),"设置成功");
        });
    }

    @PutMapping("/photoFile/cancelSetFront")
    @ApiOperation(value = "取消封面")
    public WebAsyncTask<SimpleResponse<?>> cancelSetFront(@Valid @RequestBody Integer id) {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Boolean>(photoFileService.cancelSetFront(id),"取消成功");
        });
    }

    @GetMapping("/v1/photo/homePage")
    @ApiOperation(value = "首页轮播图")
    public WebAsyncTask<SimpleResponse<?>> getCarouselList() {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            Map<String, Object> map = new HashMap<String, Object>();
            Page<PhotoVO> page = PageHelper.startPage(1, 4, true, false, false);
            List<PhotoVO> carouselList = photoService.findCarouselList();
            map.put("total", page.getTotal());
            map.put("rows", carouselList);
            return new SimpleResponse<Object>(true, "操作成功", map);
        });
    }

    @GetMapping("/v1/photo/homePage2")
    @ApiOperation(value = "首页展示图片")
    public WebAsyncTask<SimpleResponse<?>> getShowPhotoList() {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            Map<String, Object> map = new HashMap<String, Object>();
            Page<PhotoVO> page = PageHelper.startPage(1, 6, true, false, false);
            List<PhotoVO> carouselList = photoService.findCarouselList();
            map.put("total", page.getTotal());
            map.put("rows", carouselList);
            return new SimpleResponse<Object>(true, "操作成功", map);
        });
    }

}
