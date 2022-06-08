package 多线程与高并发.SynchronizedCode;

import java.util.concurrent.TimeUnit;

/**
 * @author changying
 * @date 2022/4/23
 **/
public class 父类子类可重入锁 {
    synchronized void m () {
        System.out.println("m start");
        try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("m end");
    }

    public static void main(String[] args){
        new TT().m();
    }
}

/**
 * 由于子类不能继承父类的构造方法，因此，如果要调用父类的构造方法，可以使用 super 关键字。
 * super 可以用来访问父类的构造方法、普通方法和属性。
 * super( ) 必须是在子类构造方法的方法体的第一行
 */
class TT extends 父类子类可重入锁{
    @Override
    synchronized void m(){
        System.out.println("child m start");
        super.m();
        System.out.println("child m end");
    }
}
