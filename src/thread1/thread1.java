package thread1;

public class thread1 extends Thread {

    public thread1(String name)
    {
      super(name);
    }

    public static void main(String[] args) {
        for(int i = 0; i<5 ; i++)
        {
            new thread1("thread:"+i).start();
        }
    }

    @Override
    public void run() {
        for (int i =0 ; i<10;i++)
        {

            System.out.println(this.getName()+":"+i);
        }
    }
}
