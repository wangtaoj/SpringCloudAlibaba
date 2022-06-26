package com.wangtao.ribbonexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/**
 * @author wangtao
 * Created at 2022/6/19 19:58
 */
@RequestMapping("/ribbon")
@RestController
public class RibbonController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/chooseServer")
    public String chooseServer() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-producer");
        System.out.println("getInstanceId: " + serviceInstance.getInstanceId());
        System.out.println("getServiceId: " + serviceInstance.getServiceId());
        System.out.println("getHost: " + serviceInstance.getHost());
        System.out.println("getPort: " + serviceInstance.getPort());
        System.out.println("getScheme: " + serviceInstance.getScheme());
        System.out.println("getUri: " + serviceInstance.getUri());

        // 将nacos-producer换成具体的IP+端口
        URI originalUri = URI.create("https://nacos-producer/demo");
        System.out.println(loadBalancerClient.reconstructURI(serviceInstance, originalUri));
        return serviceInstance.getUri().toString();
    }

    @GetMapping("/chooseServer1")
    public String chooseServer1() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("ribbon-example");
        return serviceInstance.getUri().toString();
    }
}
