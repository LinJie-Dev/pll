package com.pll.elasticsearch;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.pll.common.annotation.EnableGlobalException;
import org.elasticsearch.client.Client;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.EntityMapper;

import java.io.IOException;

/**
 * @Classname ElasticSearchApplication
 * @Description elasticsearch快速启动类
 * @Date 2021/5/11 19:50
 * @Author 林杰
 */
@SpringBootApplication
@EnableGlobalException
@MapperScan(basePackages = {"com.pll.elasticsearch.dao"})
public class ElasticSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticSearchApplication.class, args);
    }

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate(Client client) {
        return new ElasticsearchTemplate(client, new ElasticCustomEntityMapper());
    }

    private class ElasticCustomEntityMapper implements EntityMapper {

        private ObjectMapper mapper;

        @Autowired
        private ElasticCustomEntityMapper() {
            this.mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            mapper.registerModule(new JavaTimeModule());
        }

        @Override
        public String mapToString(Object object) throws IOException {
            return mapper.writeValueAsString(object);
        }

        @Override
        public <T> T mapToObject(String source, Class<T> clazz) throws IOException {
            return mapper.readValue(source, clazz);
        }
    }
}
