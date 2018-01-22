package Queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest {
	
	public static void main(String[] args) {
	//	Queue queue = new LinkedList();
		Queue<String> queue = new PriorityQueue<String>();
		queue.offer("one");
		queue.offer("two");
		queue.offer("three");
		queue.offer("four");
		System.out.println("Head of queue is: " + queue.peek()); 
	}

}
