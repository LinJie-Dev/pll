package com.pll.elasticsearch.service;

import com.pll.elasticsearch.model.TestQueryResponse;

/**
 * @description 测试服务对外接口
 * @date 2021/5/12 11:30
 * @author 林杰
 * @version 1.0
 */
public interface ITestService {
    /**
     * 根据用户名测试查询
     * @param userName 用户名
     * @return 用户信息
     */
    TestQueryResponse queryTestByUserName(String userName);
}
