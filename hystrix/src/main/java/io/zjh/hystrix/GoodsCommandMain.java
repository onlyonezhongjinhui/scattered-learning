package io.zjh.hystrix;

public class GoodsCommandMain {
    public static void main(String[] args) {
        GoodsService goodsService = new GoodsService();
        for (int i = 0; i < 20; i++) {
            Integer r = new GoodsCommand(goodsService).execute();
            System.out.println(r);
        }

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 20; i++) {
            Integer r = new GoodsCommand(goodsService).execute();
            System.out.println("-->" + r);
        }
    }
}
