package Packege;

import java.util.concurrent.CountDownLatch;

public class MyThread implements Runnable {

    String name;
    CountDownLatch latch;

    public MyThread(CountDownLatch cdl1, String a) {
        latch = cdl1;
        name = a;
        new Thread(this);
    }
    /**
     * @see Thread#run()
     */
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "· " + i);
            latch.countDown();
        }
    }
}

