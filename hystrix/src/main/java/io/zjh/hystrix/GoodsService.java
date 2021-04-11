package io.zjh.hystrix;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class GoodsService {

    private final AtomicInteger id = new AtomicInteger();

    public Integer queryGoodsById() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        id.incrementAndGet();
        if (id.get() < 10) {
            throw new IllegalStateException();
        }
        return id.get();
    }
}
