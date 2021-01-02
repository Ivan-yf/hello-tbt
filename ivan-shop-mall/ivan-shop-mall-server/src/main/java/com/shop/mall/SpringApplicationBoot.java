package com.shop.mall;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Ivan.luo
 * @Description springBoot启动类
 * @date 2020/12/05
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(value = "com.shop.mall.mapper")
@EnableApolloConfig({"application", "private"})
public class SpringApplicationBoot {
    public static void main(String[] args) {
        SpringApplication.run(SpringApplicationBoot.class, args);
    }
}
