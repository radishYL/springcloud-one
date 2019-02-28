package com.yl.springcloud.config;

import com.yl.other.config.RibbonConfig;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Alex
 * @since 2019/2/26 20:36
 */

@Configuration
@EnableFeignClients(basePackages = {"com.yl.api.feign"})
@RibbonClients(value = {
    @RibbonClient(name = "DEPT-PROVIDER",configuration = {RibbonConfig.class})
})
public class MainConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


}