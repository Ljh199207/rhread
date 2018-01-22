package thread1;

public class JoinTest extends Thread{
	static int result = 0; 
	public JoinTest(String name){
		super(name);
	}
	public static void main(String[] args) {
		System.out.println("���߳�ִ��"); 
		Thread t = new JoinTest("�����߳�");
		t.start(); 
		System.out.println("result��" + result);
		
		try {
			long start = System.nanoTime(); 	
			t.join();
			long end = System.nanoTime(); 
			System.out.println((end - start) / 1000000 + "�����:" + 
					result); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(t.isAlive());
	}

	 @Override
	public void run() {
		
		 System.out.println(this.getName() + "��ʼ����..."); 
		 try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 result = (int) (Math.random() * 10000); 
		 System.out.println(this.getName() + "�������㣺"); 
	}
}
