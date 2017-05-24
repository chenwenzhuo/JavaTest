package com.ventrol_chen.BasicPage11;

/**
 * Created by --C-W-Z-- on 2017/3/1 0001.
 */
public class Producer_Consumer_Model_Test {
    public static void main(String[] args) {
        Depot mDepot = new Depot(100);
        Producer mProducer = new Producer(mDepot);
        Consumer mConsumer = new Consumer(mDepot);

        mProducer.produce(60);
        mProducer.produce(120);
        mConsumer.consume(90);
        mConsumer.consume(150);
        mProducer.produce(110);
    }
}
