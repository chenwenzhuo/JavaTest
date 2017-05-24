package com.ventrol_chen.BasicPage11;

/**
 * Created by --C-W-Z-- on 2017/3/1 0001.
 */
//消费者
public class Consumer {
    private Depot depot;

    public Consumer(Depot depot) {
        this.depot = depot;
    }

    // 消费产品：新建一个线程从仓库中消费产品
    public void consume(final int val) {
        new Thread() {
            @Override
            public void run() {
                depot.consume(val);
            }
        }.start();
    }
}
