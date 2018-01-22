package countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
	
	// ��ʼ�ĵ����� 
	 final  CountDownLatch begin = new CountDownLatch(1);  
	
	// �����ĵ����� 
	
	 final  CountDownLatch end = new CountDownLatch(10);  
	
	//ʮ��ѡ��
	
	 final  ExecutorService exec = Executors.newFixedThreadPool(10);
	  
	for (int index = 0; index < 10; index++)
	{
		final int NO = index + 1;  
		Runnable run = new Runnable() {
			
			@Override
			public void run() {
				try {
					begin.await();
					Thread.sleep((long) (Math.random() * 10000));  
	                System.out.println("No." + NO + " arrived");  
				} catch (InterruptedException e) {
					e.printStackTrace();
				}  finally {
					 end.countDown();
				}
                
				
			}
		};
		exec.submit(run);
	}
	 System.out.println("Game Start");  
     // begin��һ����ʼ��Ϸ
     begin.countDown();  
     // �ȴ�end��Ϊ0��������ѡ�ֵ����յ�
     end.await();  
     System.out.println("Game Over");  
     exec.shutdown();  

}
}