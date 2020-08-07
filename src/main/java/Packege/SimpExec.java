package Packege;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpExec {


    public static void main(String args[]) {
        CountDownLatch cdl1 = new CountDownLatch(5);
        CountDownLatch cdl2 = new CountDownLatch(5);
        CountDownLatch cdlЗ = new CountDownLatch(5);
        CountDownLatch cdl4 = new CountDownLatch(5);
        ExecutorService es = Executors.newFixedThreadPool(2);
        System.out.println("Зaпycк потоков");
        es.execute(new MyThread(cdl1, "А"));
        es.execute(new MyThread(cdl2, "В"));
        es.execute(new MyThread(cdlЗ, "С"));
        es.execute(new MyThread(cdl4, "D"));
        try {
            cdl1.await();
            cdl2.await();
            cdlЗ.await();
            cdl4.await();
        } catch (InterruptedException exc) {
            System.out.println(exc);
            es.shutdown();
            System.out.println("Зaвepшeниe потоков");
        }
    }
}