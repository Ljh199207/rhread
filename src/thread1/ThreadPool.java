package thread1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool {

    public static void main(String[] args) {
        ExecutorService exs = Executors.newFixedThreadPool(2);
        for (int i =0;i<100;i++)
        {
           Runnable run = new Runner(i);
            exs.execute(run);
        }
    }

}

class Runner implements Runnable
{
	int index =0;
	public Runner(int index)
	{
	 this.index =index;	
	}

	@Override
	public void run() {
		long time = (long) (Math.random()*1000);
		System.out.println(Thread.currentThread().getName()+("目标对象"+index)+"      Sleeping"+time+"ms");
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


