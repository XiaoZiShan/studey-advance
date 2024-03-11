package advance.beauty_of_concurrent.base;

import org.junit.jupiter.api.*;
import studey.advance.beauty_of_concurrent.base.CreateEachThreadByClass;

import java.util.concurrent.FutureTask;

/**
 * 调用 start 方法后线程并没有马上执行而是处于就绪状态，就绪状态指已经获取除CPU以外的其他资源，
 * 等待获取CPU资源后才会真正处于运行专题， 一旦run方法执行完毕， 该线程就处于终止状态。
 *
 * 小结： 使用继承方式的好处是方便传参，你可以在子类里面添加成员变量，通过 set 方法设置参数
 * 或者通过构造函数进行传递，而如果使用 Runnable 方式，则只能使用主线程里面被声明为 final 的变量。
 * 不好的地方是 Java 不支持多继承，如果继承类 Thread 类， 那么子类不能再继承其他类，而Runable
 * 则没有这个限制。前两种方式都没办法拿到任务的返回结果，但是 FutureTask 方式可以。
 */
@DisplayName("1.2 线程创建与运行代码测试分析")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CreateEachThreadByClassTest extends CreateEachThreadByClass{

    /**
     * @ApiNote better piont
     * 1.继承的方式方便主线程传参，如果父类如果实现run方法, 子类可以重写或者继承, 比较简单灵活。
     * 2.可以使用 this 调用Thread类中的方法， 无需调用 Thread.currentThread().
     * @ApiNote bad point
     * 1.任务与代码没有分离， 多个线程执行一样的任务时需要多份任务代码， 意思是不再次声明新的类无法进行多线程处理同一个任务。
     * 2.Java 是单继承，不支持多继承，继承现场类后，无法再继承其他类。
     * 3.创建线程对象时并没有启动，调用 start 方法时才正式启动。
     * 4.无法直接获取线程任务的返回值。
     */
    @Test
    @Order(1)
    void CreateThreadByExtendClassTest(){
        // 创建线程
        CreateThreadByExtendClass thread = new CreateThreadByExtendClass();
        // 启动线程
        thread.start();
    }

    /**
     * @ApiNote better piont
     * 1.不需再声明新类，同一个类可多线程处理同一个任务, 这是 Thread 不具备的.
     * 2.可以在运行不同的多线程任务时，传入构造参数。
     * 3.RunableTask 可以继承其他类，因为它是接口。
     * @ApiNote bad point
     * 1.必须使用 Thread.currentThread() 才能获取当前线程属性。
     * 2.不能直接调用主线程的变量， 只能使用声明为 final 的变量。
     * 3.无法直接获取线程任务的返回值。
     */
    @Test
    @Order(2)
    void CreateThreadByImplemetsRunableTest(){
        CreateThreadByImplemetsRunable task = new CreateThreadByImplemetsRunable();
        new Thread(task).start();
        new Thread(task).start();
    }

    /**
     * @ApiNote better piont
     * 1.FutureTask 类本身继承了 Runnable 接口， 间接拥有Runable的大多数特性
     * 2.实现 Callable 接口，可以直接获取线程任务的返回值。
     * @ApiNote bad point
     * 1.出现的太晚了，不过一口气吃不了胖子 hahaha
     */
    @Test
    @Order(3)
    void CreateThreadByCallerTest(){
        // 创建异步任务
        FutureTask<String> funtruTask = new FutureTask<>(new CreateThreadByCallerTask());
        // 启动线程
        new Thread(funtruTask).start();
        try {
            // 等待任务执行完毕，并返回结果
            String result = funtruTask.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
