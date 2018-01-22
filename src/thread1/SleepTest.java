package thread1;

public class SleepTest {

	 public static void main(String[] arg) {
		 String[] args = { "one", "two", "three", "for" };
		 long star = System.nanoTime();
		 for (int i=0;i<args.length;i++)
		 {
			 System.out.println(args[i]);
			 try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 long end = System.nanoTime();
		 System.out.println("总的时间："+(end-star)/1000000);
	}
}
