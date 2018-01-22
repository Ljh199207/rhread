package thread1;

public class BackCount {
	
	private volatile int   balance;
	
	public void  updateBackcount()
	{
		balance = (int) (Math.random()*100);
	}
   
	public void showValue() throws InterruptedException
	{
		balance = 10;
		for(;;)
		{
			System.out.println(balance);
			Thread.sleep(1000);
			
		}
	}
}
