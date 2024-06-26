package advance.beauty_of_concurrent.base;

import org.junit.jupiter.api.*;
import studey.advance.beauty_of_concurrent.base.ObjectWaitFunction;

/**
 * Java 中的Object类是所有类的父类，基于继承机制，Java把所有类都需要的方法做到了
 * Object 类里面，包括接下来的 wait(), notify(), Join().
 *
 * 当一个线程调用一个共享变量的wait()方法时,该调用线程会被阻塞挂起, 知道发生下面几件事情
 * 之一才返回, (1)其他线程调用了该共享对象的notify()或者notiyAll()方法, (2)其他线程调用了
 * 该线程的intrrupt()方法, 该线程抛出了 IntrerruptedException 异常返回.
 *
 * 另外需要注意的是, 一个线程可以从挂起状态变为可运行状态 (也就是被唤醒),即使该线程没有被其他线程
 * 调用 notify(), notifyAll() 方法进行通知, 或者被中断, 或者等待超时, 这就是所谓的虚假唤醒.
 *
 * 虽然实践中很少发生,但要防范与未然, 做法是不停地去测试该线程被唤醒的条件是否满足,不满足则继续等待
 * , 也就是说一个循环中调用 wait() 方法进行防范. 退出循环的条件是满足了唤醒该线程的条件.
 *
 * synchronized (obj){
 *      while(条件不满足){
 *          obj.wait();
 *      }
 * }
 */
@DisplayName("1.3 线程通知与等待")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ObjectWaitFunctionTest extends ObjectWaitFunction{

    /**
     * @apiNote 唤醒 wait() 中的线程有以下三种方式
     * 1.其他线程调用共享对象的notify() notifyAll() 2.Thread.currentThread().interrupt()  中断当前线程 wait(). 3.极其罕见的虚假唤醒.
     * @throws InterruptedException 如果任何线程在当前线程等待之前或等待期间中断了当前线程。当抛出此异常时，当前线程的中断状态被清除.
     * @throws IllegalMonitorStateException 两个触发条件: 1.wait() 方法与 synchronized 关键字不配合使用 或者 2.上锁的共享监视器对象锁与调用wait()方法的对象不一致
     */
    @Test()
    @Order(1)
    void synchronizedKeyworkTest() throws InterruptedException,IllegalMonitorStateException{
        // 将 synchronized 关键字放在方法体内, 代表将共享的变量上锁
        this.synchronizedKeywork();

        // 将 synchronized 关键字放在声明方法上, 代表将方法进行上锁, 而监控锁就是this(当前对象本身).
        this.synchronizedFunctionKeywork();
    }

    /**
     * run 方法中 queue 为共享变量, 生产者线程在调用 queue 的 wait() 方法前, 使用 synchronized 关键字拿到了该共享变量
     * queue 的监视器锁, 所以调用wait()方法才不会抛出 IllegalMonitorStateException 异常. 如果当前队列没有空闲的容量则
     * 会调用 queue 的 wait() 方法挂起当前线程, 这里使用循环就是为了避免上面说的虚假唤醒问题. 假如当前线程被虚假唤醒了, 但是队列
     * 还是没有空余容量. 那么当前线程还是会调用 wait() 方法把之间挂起.
     * @throws InterruptedException 如果任何线程在当前线程等待之前或等待期间中断了当前线程。当抛出此异常时，当前线程的中断状态被清除.
     */
    @Test()
    @Order(2)
    void SynchronizedWaitQueueThreadTest() throws InterruptedException{
        SynchronizedWaitQueueThread task = new SynchronizedWaitQueueThread();
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }

    /**
     * 线程A获取锁后发现当前队列已满会调用 queue.wait() 方法阻塞自己, 然后释放uoqu的queue上的锁,
     * 这里考虑下为何要释放该锁? 如果不释放, 由于其他生产者线程和所有消费者线程都已经被阻塞挂起,
     * 而线程A也被挂起, 这就是处于死锁状态. 这里线程A挂起自己后释放共享变量上的锁, 就是为了打破死锁必要条件之一的持有
     * 并等待原则. 线程 A 释放锁后, 其他生产者线程和所有消费者线程中会有一个线程好哦去queue上的锁进而进入同步快, 这就
     * 打破了死锁状态.
     * @throws InterruptedException 如果任何线程在当前线程等待之前或等待期间中断了当前线程。当抛出此异常时，当前线程的中断状态被清除.
     */
    @Test()
    @Order(3)
    void synchronizedWaitRunnableTest() throws InterruptedException{
        this.synchronizedKeywork();
    }


    @Test()
    @Order(4)
    void interruptedExceptionByWaitTest() throws InterruptedException{
        this.interruptedExceptionByWait();
    }
}
