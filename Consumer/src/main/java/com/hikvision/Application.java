package com.hikvision;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author zouzhilong
 * @date 2019/11/1 15:22
 */
@EnableDubbo
@DubboComponentScan(basePackages = "com.hikvision.person")
@ImportResource(locations = {"classpath:dubbo.xml"})
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
