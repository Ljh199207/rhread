package Queue;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueDemo {

	static class NanoDelay implements Delayed
	{
		long trigger;
		NanoDelay(long i) { 
		      trigger = System.nanoTime() + i; 
		} 
		
		public boolean equals(Object other)
		{
			return ((NanoDelay) other).trigger == trigger; 
		}
		public boolean equals(NanoDelay other) { 
		      return ((NanoDelay) other).trigger == trigger; 
	    } 
		
		 public long getTriggerTime() { 
		   return trigger; 
		  } 
		 
	     public String toString() { 
		   return String.valueOf(trigger); 
		  }
	     
		    
		@Override
		public int compareTo(Delayed o) {
			long i = trigger; 
		    long j = ((NanoDelay) o).trigger; 
		  if (i < j) 
		    return -1; 
		   if (i > j) 
		    return 1; 
		   return 0;
		}

		@Override
		public long getDelay(TimeUnit unit) {
			 long n = trigger - System.nanoTime(); 
			 return unit.convert(n, TimeUnit.NANOSECONDS); 
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		  Random random = new Random(); 
		  DelayQueue<NanoDelay>  queue = new DelayQueue<NanoDelay>(); 
		    for (int i = 0; i < 5; i++) { 
		   queue.add(new NanoDelay(random.nextInt(1000))); 
		  } 
		    long last = 0; 
		    for (int i = 0; i < 5; i++) { 
		      NanoDelay delay = (NanoDelay) (queue.take()); 
		      long tt = delay.getTriggerTime(); 
		      System.out.println("Trigger time: " + tt); 
		      if (i != 0) { 
		        System.out.println("Delta: " + (tt - last)); 
		   } 
		   last = tt; 
		  } 
	}
}
