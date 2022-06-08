package 多线程与高并发.SynchronizedCode;

import java.sql.SQLOutput;

/**
 * @author changying
 * @date 2022/4/23
 **/
public class 同步非同步方法调用 {
    public class T {
        public synchronized void m1() {
            System.out.println(Thread.currentThread().getName() + " m1 strat ...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " m1 end...");
        }

        public void m2() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "m2");
        }

        public void main(String[] args) {
            T t = new T();
            new Thread(t::m1, "t1").start();
            new Thread(t::m2, "t2").start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    t.m1();
                }
            });
        }
    }
}
