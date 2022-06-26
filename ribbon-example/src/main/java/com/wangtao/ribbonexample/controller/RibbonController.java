package com.wangtao.ribbonexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
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

    @Autowired
    private SpringClientFactory springClientFactory;

    @GetMapping("/chooseServer")
    public String chooseServer() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-producer");
        System.out.println("getInstanceId: " + serviceInstance.getInstanceId());
        System.out.println("getServiceId: " + serviceInstance.getServiceId());
        System.out.println("getHost: " + serviceInstance.getHost());
        System.out.println("getPort: " + serviceInstance.getPort());
        System.out.println("getScheme: " + serviceInstance.getScheme());
        System.out.println("getUri: " + serviceInstance.getUri());

        URI originalUri = URI.create("https://nacosqqq-producer1/demo");
        System.out.println(loadBalancerClient.reconstructURI(serviceInstance, originalUri));
        return serviceInstance.getUri().toString();
    }

    @GetMapping("/chooseServer1")
    public String chooseServer1() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("ribbon-example");
        return serviceInstance.getUri().toString();
    }
}
