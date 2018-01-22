package countDownLatch;

import java.util.concurrent.CountDownLatch;

import PoolSemaphore.ResourceManage;

public class LatchDriverDemo    {
	public static void main(String[] args) throws InterruptedException {
		

		// 用于向工作线程发送启动信号 
		 CountDownLatch startSignal = new CountDownLatch(1); 
		// 用于等待工作线程的结束信号 
		 CountDownLatch doneSignal = new CountDownLatch(5); 
		 long start = System.nanoTime(); 
		 for (int i = 0; i < 5; ++i) 
		 {
			 // 主线程，递减开始计数器，让所有线程开始工作 
	           startSignal.countDown(); 
           new Thread(new LatchWorker(startSignal, doneSignal),"t"+i).start();
		 }
		// 得到线程开始工作的时间 
         
	       
	      // 主线程阻塞，等待所有线程完成 
	     doneSignal.await(); 
		 long end = System.nanoTime(); 
		 System.out.println("all worker take time（ms）:"  + (end - start) / 1000000);  

}
	static class LatchWorker implements Runnable
	{
	   private LatchDriverDemo resourceManage;   
	
		// 用于等待启动信号 
		private  CountDownLatch startSignal; 
		// 用于发送结束信号 
		private  CountDownLatch doneSignal; 
		
		public LatchWorker(CountDownLatch startSignal, CountDownLatch doneSignal) { 
				   this.startSignal = startSignal; 
				   this.doneSignal = doneSignal; 
				   this.resourceManage = new LatchDriverDemo();
	    }
		@Override
		public void run() {
			try {
				startSignal.await();
				Thread.sleep((long) (Math.random() * 10000));  
				resourceManage.doWork();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			finally
			{
				doneSignal.countDown();// 发送完成信号 
			}
		}
	
	}
	public void doWork() { 
		  System.out.println(Thread.currentThread().getName() + " is working..."); 
		 }
	  
}
