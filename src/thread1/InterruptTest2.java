package thread1;

public class InterruptTest2 extends Thread {
	static int result = 0; 
	public InterruptTest2(String name)
	{
		super(name);
	}
	public static void main(String[] args) {
		System.out.println("���߳�ִ��"); 
		Thread t = new InterruptTest2("�����߳�"); 
	    t.start(); 
		System.out.println("result��" + result);
		try {
			long start = System.nanoTime();
			t.join(2);
			long end = System.nanoTime();
			t.interrupt();
			System.out.println((end - start) / 1000000 + "�����:" + result); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		System.out.println(this.getName()+"��ʼ����...");
		for(int i = 0; i < 100000; i++)
		{
			result++;
			if(Thread.interrupted())
			{
				System.out.println(this.getName() + "���ж�"); 
				return; 
			}
		}
		System.out.println(this.getName() + "��������"); 
	}
	

}
