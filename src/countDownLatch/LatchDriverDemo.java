package countDownLatch;

import java.util.concurrent.CountDownLatch;

import PoolSemaphore.ResourceManage;

public class LatchDriverDemo    {
	public static void main(String[] args) throws InterruptedException {
		

		// ���������̷߳��������ź� 
		 CountDownLatch startSignal = new CountDownLatch(1); 
		// ���ڵȴ������̵߳Ľ����ź� 
		 CountDownLatch doneSignal = new CountDownLatch(5); 
		 long start = System.nanoTime(); 
		 for (int i = 0; i < 5; ++i) 
		 {
			 // ���̣߳��ݼ���ʼ���������������߳̿�ʼ���� 
	           startSignal.countDown(); 
           new Thread(new LatchWorker(startSignal, doneSignal),"t"+i).start();
		 }
		// �õ��߳̿�ʼ������ʱ�� 
         
	       
	      // ���߳��������ȴ������߳���� 
	     doneSignal.await(); 
		 long end = System.nanoTime(); 
		 System.out.println("all worker take time��ms��:"  + (end - start) / 1000000);  

}
	static class LatchWorker implements Runnable
	{
	   private LatchDriverDemo resourceManage;   
	
		// ���ڵȴ������ź� 
		private  CountDownLatch startSignal; 
		// ���ڷ��ͽ����ź� 
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
				doneSignal.countDown();// ��������ź� 
			}
		}
	
	}
	public void doWork() { 
		  System.out.println(Thread.currentThread().getName() + " is working..."); 
		 }
	  
}
