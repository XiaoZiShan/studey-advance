package studey.advance.beauty_of_concurrent.base;

import java.util.concurrent.LinkedBlockingQueue;


public class ObjectWaitFunction {
    public void synchronizedKeywork() throws InterruptedException{
        synchronized(this){
            // doSomething
            this.wait();
            this.doSomething();
        }
    }

    public synchronized void synchronizedFunctionKeywork(Integer i) throws InterruptedException{
        i.wait();
        // doSomething
        this.doSomething();
    } 

    public static class SynchronizedWaitQueueThread implements Runnable{
        @Override
        public void run() {
            LinkedBlockingQueue<Long> queue = new LinkedBlockingQueue<>();
            final Integer MAX_SIZE = 10;
            
            // 生产者线程
            synchronized (queue){
                // 消费队列满，则等待队空闲
                while(queue.size() == MAX_SIZE){
                    try{
                        // 挂起当前线程，并释放通过同步块获取的queue上的锁，
                        // 让消费者线程可以获取该锁，然后获取队列里面的元素
                        queue.wait();
    
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
                // 空闲则生成元素， 并通知消费者线程
                queue.add(System.currentTimeMillis());
                queue.notifyAll();
            }
    
            // 消费者线程
            synchronized (queue){
                // 消费队列为空
                while(queue.size() == 0){
                    try {
                        // 挂起当前线程， 并释放方法内的queue上的锁，让生产者线程可以获取该锁，将生产元素放入队列
                        queue.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
    
                // 消费元素，并通知唤醒生产者线程
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.notifyAll();
            }
        }
    }


    public void doSomething(){
        System.out.println(Thread.currentThread() + "doSomething...");
    }

    // 创建资源
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public  void synchronizedWaitRunnable() throws InterruptedException{
        // 创建线程 A (基于jdk 1.8 lambda简化)
        Thread threadA = new Thread(() ->{
            try {
                // 获取resourceA共享资源的监视器锁
                System.out.println("threadA get resourceA lock");
                // 获取resourceB共享资源的监视器锁
                synchronized (resourceB){
                    System.out.println("threadA get resouceB lock");

                    // 线程A阻塞， 并释放获取到的resourceA的锁
                    System.out.println("threadA release resourceA lock");
                    resourceA.wait();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
   
        // 创建线程 B (基于jdk 1.8 lambda简化)
        Thread threadB = new Thread(() ->{
            try {
                // 休眠 1s
                Thread.sleep(1000);
                // 获取resourceA共享资源的监视器锁
                synchronized (resourceA){
                    System.out.println("threadB get resourceA lock");
                    System.out.println("threadB try get resourceB look...");
                    
                    // 获取resourceB共享资源的监视器锁
                    synchronized (resourceB){
                        System.out.println("threadB get resourceB lock");
                    
                        // 线程B阻塞，并释放获取到的resourceA的锁
                        System.out.println("threadB release resourceA lock");
                        resourceA.wait();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // 启动线程
        threadA.start();
        threadB.start();

        // 等待两个线程结束
        threadA.join();
        threadB.join();
        
        System.out.println("main over");
    }

    static Object obj = new Object();    

    public void interruptedExceptionByWait() throws InterruptedException{
        // 创建线程
        Thread threadA = new Thread(()->{
            try {
                System.out.println("---begin---");
                // 阻塞当前线程
                synchronized (obj){
                    obj.wait();
                }
                System.out.print("----end---");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        threadA.start();

        Thread.sleep(1000);

        System.out.println("---begin interrupt threadA---");
        threadA.interrupt();
        System.out.println("---end interrupt threadA---");
    }
}

