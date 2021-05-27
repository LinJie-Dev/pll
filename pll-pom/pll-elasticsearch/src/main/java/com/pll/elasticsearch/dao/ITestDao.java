package com.pll.elasticsearch.dao;

import com.pll.elasticsearch.model.TestQueryResponse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description 测试服务数据交互层
 * @date 2021/5/12 11:33
 * @author 林杰
 * @version 1.0
 */
@Mapper
public interface ITestDao {

    /**
     * 根据用户名测试查询
     * @param userName 用户名
     * @return 用户信息
     */
    TestQueryResponse queryTestByUserName(@RequestParam("userName") String userName);
}
