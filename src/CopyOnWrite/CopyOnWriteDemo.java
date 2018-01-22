package CopyOnWrite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteDemo {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		String[]  ss={ "aa", "bb", "cc"};
		
		List list1 = new CopyOnWriteArrayList(Arrays.asList(ss));
		List list2 = new ArrayList(Arrays.asList(ss)); 
		Iterator itor1 = list1.iterator(); 
	    Iterator itor2 = list2.iterator();
	    list1.add("new");
	    list2.add("new"); 
	    
	    //printAll(itor1);
	    
	    printAll(itor2); 
	    
	}
@SuppressWarnings("unused")
private static void printAll(Iterator itor)
   {
	   while(itor.hasNext())
	   {
		   System.out.println(itor.next());
	   }
   }
}
