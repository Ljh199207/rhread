package AtomicCounter;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicAccount {
	
	AtomicLong balance;
	
	public AtomicAccount(long money) { 
		  balance = new AtomicLong(money); 
		  System.out.println("Totle Money: " + balance); 
	 } 
	
	public void deposit(long money) { 
		   balance.addAndGet(money); 
	} 
	
	public void withdraw(long money, int delay)
	{
		long oldvalue = balance.get();
		if(oldvalue >=money)
		{
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (balance.compareAndSet(oldvalue, oldvalue - money)) { 
		        System.out.println(Thread.currentThread().getName() 
		           + " withdraw  " + money + " successful!" + 
		    balance);
		}
		else
		{
			System.out.println(Thread.currentThread().getName() 
				       + "thread concurrent, withdraw failed!" + 
				balance); 
		}
		}
		else
		{
			   System.out.println(Thread.currentThread().getName() 
					      + " balance is not enough,withdraw failed!" + 
					balance);
		}
	}
	
	public long get() { 
		   return balance.get(); 
		 } 
}
