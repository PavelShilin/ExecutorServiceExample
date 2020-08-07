package Packege;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpExec {


    public static void main(String[] args) {
        CountDownLatch cdl1 = new CountDownLatch(3);
        CountDownLatch cdl2 = new CountDownLatch(3);
        CountDownLatch cdl3 = new CountDownLatch(3);
        CountDownLatch cdl4 = new CountDownLatch(3);
        ExecutorService es = Executors.newFixedThreadPool(3);
        System.out.println("Зaпycк потоков");
        es.execute(new MyThread(cdl1, "А"));
        es.execute(new MyThread(cdl2, "В"));
        es.execute(new MyThread(cdl3, "С"));
        es.execute(new MyThread(cdl4, "D"));
        try {
            cdl1.await();
            cdl2.await();
            cdl3.await();
            cdl4.await();
        } catch (InterruptedException exc) {
            System.out.println(exc);

        }
        es.shutdown();
        System.out.println("Зaвepшeниe потоков");
    }
}