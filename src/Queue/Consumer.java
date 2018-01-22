package Queue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

	private final BlockingQueue<String> queue;
	
	public Consumer (BlockingQueue<String> q)
	{
		queue=q;
	}
	
	@Override
	public void run() {
		try {
		for (int i = 0; i < 100; i++) { 
				cousume(queue.take());
	     	} 
		}
		catch (InterruptedException e) {
				e.printStackTrace();
			}
	}
	
	public void cousume(String x)
	{
		System.out.println("consume " + x);
	}

}
