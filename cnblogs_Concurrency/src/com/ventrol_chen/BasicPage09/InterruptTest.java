package com.ventrol_chen.BasicPage09;

/**
 * Created by --C-W-Z-- on 2017/2/24 0024.
 */
public class InterruptTest {
    public static void main(String[] args) {
        try{
            //新建线程t1
            Thread t1 = new MyThread("t1");
            System.out.println(t1.getName() + "(" + t1.getState() + ") is new.");

            //启动线程t1
            t1.start();
            System.out.println(t1.getName() + "(" + t1.getState() + ") is started.");

            // 主线程休眠300ms，然后主线程给t1发“中断”指令
            Thread.sleep(300);
            t1.interrupt();
            System.out.println(t1.getName() + "(" + t1.getState() + ") is interrupted.");

            //主线程休眠300ms，然后查看t1的状态
            Thread.sleep(300);
            System.out.println(t1.getName() + "(" + t1.getState() + ") is interrupted now.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            int i = 0;
            while (!isInterrupted()) {
                i++;
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName()
                        + "(" + this.getState() + ") loop " + i);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()
                    +" ("+this.getState()+") catch InterruptedException.");
        }
    }
}