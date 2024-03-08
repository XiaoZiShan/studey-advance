package studey.advance.beauty_of_concurrent.base;

public class ObjectNotifyFunction {
    private static volatile Object resourceA = new Object();

    public void notifyAlls() throws InterruptedException {
        // 创建线程A
        Thread threadA = new Thread(() ->{
            // 获取resourceA共享资源的监视器锁
            synchronized(resourceA){
            System.out.println("threadA get resourceA lock");
            try {
                System.out.println("threadA begin wait");
                resourceA.wait();
                System.err.println("threadA end wait");
            } catch (Exception e) {
                e.printStackTrace();
            }
          }
        });

        // 创建线程B
        Thread threadB = new Thread(() ->{
            // 获取resourceA共享资源的监视器锁
            synchronized(resourceA){
            System.out.println("threadB get resourceA lock");
            try {
                System.out.println("threadB begin wait");
                resourceA.wait();
                System.err.println("threadB end wait");
            } catch (Exception e) {
                e.printStackTrace();
            }
          }
        });


        // 创建线程C
        Thread threadC = new Thread(() ->{
            // 获取resourceA共享资源的监视器锁
            synchronized(resourceA){
            System.out.println("threadC get resourceA lock");
            try {
                System.out.println("threadC begin wait");
                resourceA.wait();
                System.err.println("threadC end wait");
            } catch (Exception e) {
                e.printStackTrace();
            }
          }
        });

        // 启动线程
        threadA.start();
        threadB.start();
        
        Thread.sleep(1000);
        threadC.start();

        // 等待线程结束
        threadA.join();
        threadB.join();
        threadC.join();

        System.out.println("main over");
    }
}
