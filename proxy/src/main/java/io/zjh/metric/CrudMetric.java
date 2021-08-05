package io.zjh.metric;

import java.util.concurrent.atomic.AtomicInteger;

public class CrudMetric {

    private final static AtomicInteger insertCount = new AtomicInteger(0);
    private final static AtomicInteger updateCount = new AtomicInteger(0);
    private final static AtomicInteger deleteCount = new AtomicInteger(0);
    private final static AtomicInteger selectCount = new AtomicInteger(0);

    public static void increaseInsert() {
        insertCount.incrementAndGet();
    }

    public static void increaseUpdate() {
        updateCount.incrementAndGet();
    }

    public static void increaseDelete() {
        deleteCount.incrementAndGet();
    }

    public static void increaseSelect() {
        selectCount.incrementAndGet();
    }

    public static void metric() {
        System.out.println("----------------metric-------------------");
        System.out.println("insert count : " + insertCount.get());
        System.out.println("update count : " + updateCount.get());
        System.out.println("delete count : " + deleteCount.get());
        System.out.println("select count : " + selectCount.get());
        System.out.println("----------------metric-------------------");
    }

    public static void clear() {
        insertCount.set(0);
        updateCount.set(0);
        deleteCount.set(0);
        selectCount.set(0);
    }

}
