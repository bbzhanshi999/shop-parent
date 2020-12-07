package com.neuedu.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService3 {
    int i = 0;

    @SentinelResource(
            value = "message",
            blockHandlerClass = OrderServiceImpl3BlockHandlerClass.class,
            blockHandler = "blockHandler",
            fallbackClass = OrderServiceImpl3FallbackClass.class,
            fallback = "fallback"
    )
    public String message() {
        i++;
        if (i % 3 == 0) {
            throw new RuntimeException();
        }
        return "message";
    }

    //BlockException时进入的方法
    public String blockHandler(BlockException ex) {
        log.error("{}", ex);
        return "接口被限流或者降级了...";
    }

    //Throwable时进入的方法
    public String fallback(Throwable throwable) {
        log.error("{}", throwable);
        return "接口发生异常了...";
    }

    @Slf4j
    public static class OrderServiceImpl3BlockHandlerClass {
        //注意这里必须使用static修饰方法
        public static String blockHandler(BlockException ex) {
            log.error("{}", ex);
            return "接口被限流或者降级了...";
        }
    }
    @Slf4j
    public static class OrderServiceImpl3FallbackClass {
        //注意这里必须使用static修饰方法
        public static String fallback(Throwable throwable) {
            log.error("{}", throwable);
            return "接口发生异常了...";
        }
    }
}
