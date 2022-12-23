package com.pde.pdes.portal.user.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pde.pdes.portal.Constants.Constants;
import com.pde.pdes.portal.video.dto.VideoQueryCondition;
import com.pde.pdes.portal.video.po.VideoPO;
import com.pde.pdes.portal.vo.SimpleResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: mth
 * @date: 2022/12/3
 * @description:
 */
@Api(tags = {"用户服务"})
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @GetMapping("/info")
    @ApiOperation(value = "获取用户信息")
    public WebAsyncTask<SimpleResponse<?>> getUserInfo() {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            Map<String, Object> map = new HashMap<String, Object>();
            List<String> roles = Arrays.asList("admin");
            map.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
            map.put("roles", roles);
            map.put("name", "Super Admin");
            map.put("introduction", "I am a super administrator");
            return new SimpleResponse<Object>(true, "操作成功", map);
        });
    }

    @PostMapping("/logout")
    @ApiOperation(value = "用户登出")
    public WebAsyncTask<SimpleResponse<?>> logout() {
        return new WebAsyncTask<SimpleResponse<?>>(30 * 1000L, Constants.EXECUTOR_NAME, () -> {
            return new SimpleResponse<Object>(true, "success");
        });
    }
}
