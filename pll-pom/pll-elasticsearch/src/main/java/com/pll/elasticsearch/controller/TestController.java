package com.pll.elasticsearch.controller;

import com.pll.common.base.BaseResult;
import com.pll.elasticsearch.aspect.MethodLogger;
import com.pll.elasticsearch.model.TestQueryResponse;
import com.pll.elasticsearch.service.ITestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname TestController
 * @Description 测试入口
 * @Date 2021/5/12 10:43
 * @Author 林杰
 */
@Api(tags = "测试接口")
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private ITestService testService;

    @MethodLogger
    @ApiOperation("测试查询")
    @GetMapping("/query/{userName}")
    public BaseResult<TestQueryResponse> query(@PathVariable String userName) {
        return BaseResult.createWebSuccessResult(testService.queryTestByUserName(userName));
    }
}
