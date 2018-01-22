package cyclicBarrier;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {
	// 徒步需要的时间: Shenzhen, Guangzhou, Chongqing 
	  private static int[] timeForWalk = { 5, 8, 15 }; 
	  // 自驾游 
	  private static int[] timeForSelf = { 1, 3, 4 }; 
	  // 旅游大巴 
	  private static int[] timeForBus = { 2, 4, 6 };

	  static String nowTime() {
		  //时间格式化 
		    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss"); 
		    return sdf.format(new Date()) + ": "; 
		 }
	  
	  static class Tour implements Runnable
	  {
		  	private int[] timeForUse; 
		    private CyclicBarrier barrier; 
		    private String tourName; 
	
		    public  Tour(CyclicBarrier barrier, String tourName, int[] timeForUse) 
		    { 
		       this.timeForUse = timeForUse; 
		       this.tourName = tourName; 
		       this.barrier = barrier; 
		    }   
		    
		@Override
		public void run() {
			try {
				Thread.sleep(timeForUse[0] * 1000);
				System.out.println(nowTime() + tourName + " Reached ShenZhen"); 
				barrier.await();
				Thread.sleep(timeForUse[1] * 1000); 
				System.out.println(nowTime() + tourName + " Reached Guangzhou"); 
				barrier.await();
				Thread.sleep(timeForUse[2] * 1000); 
				System.out.println(nowTime() + tourName + " Reached Chongqing"); 
				barrier.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		  
		}
		  
	  }
	  
	  public static void main(String[] args) {
		  Runnable runner = new Runnable() { 
			@Override 
		 public void run() { 
			     System.out.println("we all are here."); 
			   } 
			    };
			    CyclicBarrier barrier = new CyclicBarrier(4, runner); 
			    //使用线程池 
			    ExecutorService exec = Executors.newFixedThreadPool(3); 
			    exec.submit(new Tour(barrier, "WalkTour", timeForWalk)); 
			    exec.submit(new Tour(barrier, "SelfTour", timeForSelf)); 
			    exec.submit(new Tour(barrier, "BusTour", timeForBus)); 
			    exec.shutdown(); 
	}
}
