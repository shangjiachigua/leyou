package com.leyou.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author tianwenwen
 * @date 2019/8/3 11:31
 **/
@EnableZuulProxy
@SpringCloudApplication
public class LyGeteway {
    public static void main(String[] args) {
        SpringApplication.run(LyGeteway.class);
    }
}
