package thread1;

public class MyThread2  implements  Runnable{

    public static void main(String[] args) {

        for (int i = 0;i<10;i++)
        {
            Runnable a = new MyThread2();
            new Thread(a,"thread"+i).start();
        }
    }

    @Override
    public void run() {
      for (int i =0; i<20;i++)
      {
          System.out.println(Thread.currentThread().getName()+":"+i);
      }

    }
}
