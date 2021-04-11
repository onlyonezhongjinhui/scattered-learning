package io.zjh.hystrix;

import com.netflix.hystrix.*;

public class GoodsCommand extends HystrixCommand<Integer> {

    private final GoodsService goodsService;

    protected GoodsCommand(GoodsService goodsService) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GoodsService"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("QueryGoodsById"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        //至少有10个请求，熔断器才进行错误率的计算
                        .withCircuitBreakerRequestVolumeThreshold(10)
                        //熔断器中断请求5秒后会进入半打开状态,放部分流量过去重试
                        .withCircuitBreakerSleepWindowInMilliseconds(5000)
                        //错误率达到50开启熔断保护
                        .withCircuitBreakerErrorThresholdPercentage(50)
                        .withExecutionTimeoutEnabled(true))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties
                        .Setter().withCoreSize(10)));
        this.goodsService = goodsService;
    }

    @Override
    protected Integer run() throws Exception {
        return goodsService.queryGoodsById();
    }

    @Override
    protected Integer getFallback() {
        return -1;
    }
}
