package 多线程与高并发.SynchronizedCode;

import sun.net.www.http.HttpClient;

/**
 * @author changying
 * @date 2022/5/14
 **/
public class 多线程中断和异常 {
    // 中断处理
    public void run(){
        while(true){
            System.out.println(Thread.currentThread().getName() + "Thread.sleep begin");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + "Thread.sleep end");
        }catch(InterruptedException e){
            // 由于调用sleep()方法清楚状态标志位，所以需要在这重新重置中断标志位(下一行)，否则线程会继续运行下去
            Thread.currentThread().interrupt();
            logger.error(Thread.currentThread().getName() + "InterruptedException", e);
        }
    }

    // 异常处理。这程序有问题，主线程捕捉不到子线程异常
    public static void main(String[] args){
        try{
            new Thread(new Runnable() {
                public void run() {
                    HttpClient.New("www.sakura.com");
                }
            }).start();
        }catch (Exception e){
            logger.error("请求异常");
        }
    }
}
