package AtomicCounter;

public class AtomicAccountTest  extends Thread {
	  AtomicAccount account; 
	  int delay; 
	  public AtomicAccountTest(AtomicAccount account, int delay) { 
	   this.account = account; 
	   this.delay = delay; 
	 } 
	  public void run() { 
	   account.withdraw(100, delay); 
	 } 
	  public static void main(String[] args) { 
	  AtomicAccount account = new AtomicAccount(100); 
	  AtomicAccountTest accountThread1 = new 
	AtomicAccountTest(account, 1000); 
	  AtomicAccountTest accountThread2 = new 
	 AtomicAccountTest(account, 0); 
	  accountThread1.start(); 
	  accountThread2.start(); 
	 } 
}
