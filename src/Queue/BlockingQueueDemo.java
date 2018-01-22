package Queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class BlockingQueueDemo {
   
	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(5); 
		Producer p = new Producer(queue); 
		Consumer c1 = new Consumer(queue); 
	    Consumer c2 = new Consumer(queue); 
	  /* Thread th1 =   new Thread(p);
	   Thread th2 =  new Thread(c1); 
	   Thread th3 =  new Thread(c2); 
	   th1.start();
	   th2.start();
	   th3.start();*/
	    new Thread(p).start(); 
	    new Thread(c1).start(); 
	    new Thread(c2).start(); 
	   
	  
	}
	
}
