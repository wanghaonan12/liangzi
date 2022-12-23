package com.pde.pdes.portal.news.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pde.pdes.portal.Constants.Constants;
import com.pde.pdes.portal.company.dto.QueryCondition;
import com.pde.pdes.portal.news.po.NewsFilePo;
import com.pde.pdes.portal.news.po.NewsPo;
import com.pde.pdes.portal.news.service.NewsFileService;
import com.pde.pdes.portal.news.service.NewsService;
import com.pde.pdes.portal.vo.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.WebAsyncTask;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 新闻接口
 *
 * @author 沈建树
 */
@Api(tags = {"新闻服务"})
@RestController
@RequestMapping("/news")
public class NewsController {
    @Resource
    NewsService newsService;
    @Resource
    NewsFileService newsFileService;

    @PostMapping("/find")
    @ApiOperation("获取新闻列表")
    public WebAsyncTask<SimpleResponse<Map<String, Object>>> find(@RequestBody QueryCondition query) {
        return new WebAsyncTask<>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            if (newsService.getNews(query.getSearchText())==null){
                return new SimpleResponse<>(true, "操作成功", null);
            }
            Map<String, Object> map = new HashMap<>(2);
            try (Page<NewsFilePo> page = PageHelper.startPage(query.getPageNum(), query.getPageSize(), true, false, false)) {
                List<NewsPo> news = newsService.getNews(query.getSearchText());
                map.put("total", page.getTotal());
                map.put("rows", news);
            }
            return new SimpleResponse<>(true, "操作成功", map);
        });
    }

    @GetMapping("/findById")
    @ApiOperation("根据ID获取新闻")
    public WebAsyncTask<SimpleResponse<NewsPo>> findById(Integer id) {
        return new WebAsyncTask<>(30 * 1000L, Constants.EXECUTOR_NAME, () -> new SimpleResponse<>(newsService.getNewsById(id)));
    }

    @PostMapping("/add")
    @ApiOperation("添加新闻")
    public WebAsyncTask<SimpleResponse<Boolean>> add(@RequestBody NewsPo newsPo) {
        System.out.println(newsPo);
        return new WebAsyncTask<>(30 * 1000L, Constants.EXECUTOR_NAME, () -> new SimpleResponse<>(newsService.addNews(newsPo)));
    }

    @DeleteMapping("/delete")
    @ApiOperation("根据ID列表批量删除新闻")
    public WebAsyncTask<SimpleResponse<Boolean>> delete(@RequestBody Integer[] ids) {
        return new WebAsyncTask<>(30 * 1000L, Constants.EXECUTOR_NAME, () -> new SimpleResponse<>(newsService.deleteNewsByIds(ids)));
    }

    @PostMapping("/update")
    @ApiOperation("根据新闻实体参数ID更新")
    public WebAsyncTask<SimpleResponse<Boolean>> update(@RequestBody NewsPo newsPo) {
        return new WebAsyncTask<>(30 * 1000L, Constants.EXECUTOR_NAME, () -> new SimpleResponse<>(newsService.update(newsPo)));
    }
}
