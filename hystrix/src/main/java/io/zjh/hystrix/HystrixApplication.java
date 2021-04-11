package io.zjh.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HystrixApplication implements ApplicationRunner {

    @Autowired
    private GoodsService goodsService;

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments arg0) throws Exception {
        Integer r = new GoodsCommand(goodsService).execute();
        System.out.println(r);
    }
}
