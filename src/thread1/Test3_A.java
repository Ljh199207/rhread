package thread1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

public class Test3_A {

    public static void main(String[] args) {

        final Semaphore sema = new Semaphore(10);
        final SynchronousQueue<String> queue = new SynchronousQueue<String>();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        sema.acquire();
                        String input = queue.take();
                        String out = TestDo2.doSome(input);
                        System.out.println(Thread.currentThread().getName() + ":" + out);
                        sema.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }


        System.out.println("begin:" + (System.currentTimeMillis() / 1000));
        for (int i = 0; i < 10; i++) {  //这行不能改动
            String input = i + "";  //这行不能改动
            try {
                queue.put(input);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // System.out.println(Thread.currentThread().getName()+ ":" + output);

        }
    }
}
    //不能改动此TestDo类
    class TestDo2 {
        public static String doSome(String input){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String output = input + ":"+ (System.currentTimeMillis() / 1000);
            return output;
        }

    }

