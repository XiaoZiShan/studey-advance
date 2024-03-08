package studey.advance.beauty_of_concurrent.base;

import java.util.concurrent.Callable;

/**
 * Java中有三种线程创建方式，分别为实现 Runnable 接口的run 方法， 继承 Thread 类并重写run方法，
 * 使用 FutureTask 方式。
 */
public class CreateEachThreadByClass {
    public static class CreateThreadByExtendClass extends Thread {
        @Override
        public void run(){            
            System.out.println("I am a child thread "+this.getName());
        }
    }

    public static class CreateThreadByImplemetsRunable implements Runnable{
        @Override
        public void run() {
            System.out.println("I am a child thread"+ Thread.currentThread().getName());
        }
    }

    public static class CreateThreadByCallerTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            return Thread.currentThread().getName() + "hello";
        }
    }
}