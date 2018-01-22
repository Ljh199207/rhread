package PoolSemaphore;

import PoolSemaphore.ResourceManage.ResourceUser;

public class A {

	 public static void main(String[] args) {
		 ResourceManage resourceManage = new ResourceManage();
		 Thread[] threads = new Thread[100];  
		 for (int i = 0; i < 100; i++) {    
	            Thread thread = new Thread(new ResourceUser(resourceManage,i));//创建多个资源使用者    
	            threads[i] = thread;    
	        } 
		 for(int i = 0; i < 100; i++){    
	            Thread thread = threads[i];    
	            try {    
	                thread.start();//启动线程    
	            }catch (Exception e){    
	                e.printStackTrace();    
	            }    
		 }
		 
	}
}
