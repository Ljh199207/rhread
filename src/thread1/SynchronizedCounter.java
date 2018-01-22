package thread1;



public class SynchronizedCounter {
	
	private  int value =0;
	 
	public SynchronizedCounter (int value)
	{
		this.value = value;
	}
	private synchronized int getValue()
	{
		return value;
	}
	public synchronized int increment() {  
		return ++value; 
	}
	
	public synchronized int decrement() { 
		   return --value; 
   } 
   
	static class incrementRun implements Runnable
	{
		SynchronizedCounter account;
		@Override
		public void run() {
			for(int i =0;i<1000;i++)
			{
				account.increment();
			}
		}
		
	}
	static class decrementRun implements Runnable
	{
		SynchronizedCounter account;
		@Override
		public void run() {
			for(int i =0;i<1000;i++)
			{
				account.decrement();
			}
		}
		
	}
   
	 public static void main(String[] args) throws InterruptedException  {
		 SynchronizedCounter  account= new SynchronizedCounter(10);
		 Thread t1 = new Thread(new decrementRun(), "decrementRun"); 
		 Thread t2 = new Thread(new incrementRun(), "incrementRun"); 
		 t1.start();
		 t2.start();
		 System.out.println(account.getValue());
	}
	
}
