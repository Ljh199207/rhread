package thread1;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test4 extends Thread {

    private TestDo4 testDo4;
    private String key;
    private String value;

    public Test4(String key,String key2,String value){
        this.testDo4 = TestDo4.getInstance();
            /*常量"1"和"1"是同一个对象，下面这行代码就是要用"1"+""的方式产生新的对象（因为是编译后才相加的），
            以实现内容没有改变，仍然相等（都还为"1"），但对象却不再是同一个的效果*/
        this.key = key+key2;
        this.value = value;
    }


    public static void main(String[] args) throws InterruptedException{
        Test4 a = new Test4("1","","1");
        Test4 b = new Test4("1","","2");
        Test4 c = new Test4("3","","3");
        Test4 d = new Test4("4","","4");
        System.out.println("begin:"+(System.currentTimeMillis()/1000));
        a.start();
        b.start();
        c.start();
        d.start();

    }

    public void run(){
        testDo4.doSome(key, value);
    }
}

class TestDo4 {

    private TestDo4() {}
    private static TestDo4 _instance = new TestDo4();
    public static TestDo4 getInstance() {
        return _instance;
    }
    private CopyOnWriteArrayList keys = new  CopyOnWriteArrayList();
    public void doSome(Object key, String value) {
        Object o = key;
        if(!keys.contains(o))
        {
            keys.add(o);
        }
        else
        {
            for (Iterator iter = keys.iterator();iter.hasNext();)
            {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Object oo = iter.next();
                if(oo.equals(o)){
                    o = oo;
                    break;
                }

            }
        }
        synchronized(o)
        // 以大括号内的是需要局部同步的代码，不能改动!
        {
            try {
                Thread.sleep(1000);
                System.out.println(key+":"+value + ":"
                        + (System.currentTimeMillis() / 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
