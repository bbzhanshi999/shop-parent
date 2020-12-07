package com.neuedu.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class OrderService2 {
    @SentinelResource("message")
    public void message() {
        System.out.println("message");
    }
}
