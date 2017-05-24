package com.ventrol_chen.BasicPage11;

/**
 * Created by --C-W-Z-- on 2017/3/1 0001.
 */
//生产者
public class Producer {
    private Depot depot;

    public Producer(Depot depot) {
        this.depot = depot;
    }

    // 消费产品：新建一个线程向仓库中生产产品
    public void produce(final int val) {
        new Thread() {
            @Override
            public void run() {
                depot.produce(val);
            }
        }.start();
    }
}
