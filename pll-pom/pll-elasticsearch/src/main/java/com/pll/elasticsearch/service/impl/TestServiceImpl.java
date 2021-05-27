package com.pll.elasticsearch.service.impl;

import com.pll.elasticsearch.dao.ITestDao;
import com.pll.elasticsearch.model.TestQueryResponse;
import com.pll.elasticsearch.service.ITestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname TestServiceImpl
 * @Description 测试服务业务实现
 * @Date 2021/5/12 11:32
 * @Author 林杰
 */
@Service
public class TestServiceImpl implements ITestService {

    @Resource
    private ITestDao testDao;

    /**
     * @description 根据用户名测试查询
     * @date 2021/5/12 11:34
     * @author 林杰
     * @version 1.0
     * @param userName 用户名
     * @return 用户信息
     */
    @Override
    public TestQueryResponse queryTestByUserName(String userName) {
        return testDao.queryTestByUserName(userName);
    }
}
