package studey.advance.beauty_of_concurrent.base;

public class ObjectJoinFunction {
    public void JoinOne() throws InterruptedException {
        Thread threadOne = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("child threadOne over!");
        });

        Thread threadTwo = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("child threadTwo over!");
        });

        // 启动子线程
        threadOne.start();
        threadTwo.start();

        System.out.println("wait all child thread over!");

        // 等待子线程执行完毕， 返回
        threadOne.join();
        threadTwo.join();

        System.out.println("all chid thread over!");
    }
 
    public void JoinTwo() throws InterruptedException {
        // 线程一
        Thread threadOne = new Thread(() -> {
            System.out.println("threadOne begin run!");
            for (;;) {}
        });

        // 获取主线程
        final Thread mainThread = Thread.currentThread();

        // 线程二
        Thread threadTwo = new Thread(() -> {
            // 休眠 1 s
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 中断主线程
            mainThread.interrupt();
        });

        // 启动子线程
        threadOne.start();

        // 延迟1s启动线程
        threadTwo.start();

        try { // 等待线程one执行结束
            threadOne.join();
        } catch (Exception e) {
            System.err.println("mian thread:"+ e);
        }
    }
}
