package Queue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	@SuppressWarnings("unused")
	private final BlockingQueue<String> queue;
	
	public Producer(BlockingQueue<String> q)
	{
		queue = q; 
	}
	
	@Override
	public void run() {
		
		for (int i = 0; i < 100; i++) {
			
			try {
				queue.put(produce());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String produce()
	{
		  String temp = "" + (char) ('A' + (int) (Math.random() * 26)); 
		  System.out.println("produce " + temp); 
		  return temp;
	}

}
