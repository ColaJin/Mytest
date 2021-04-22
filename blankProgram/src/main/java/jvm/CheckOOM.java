package jvm;

import java.util.ArrayList;


//-Xms: 设置初始化内存分配大小  1/64
//-Xmx: 设置最大分配内存 默认1/4  打印GC垃圾回收信息
//-XX:+HeapDumpOnOutOfMemoryError   :OOM Dump

//-Xms1m -Xmx8m -XX:+HeapDumpOnOutOfMemoryError
//Dumping heap to java_pid28408.hprof ...
public class CheckOOM {
    byte[] array = new byte[1*1024*1024];//1M

    public static void main(String[] args) {
        ArrayList<CheckOOM> list = new ArrayList<>();

        int count = 0;

        /*try {
            while (true){
                list.add(new CheckOOM());
                count++;
            }
        } catch (Exception e) {
            //Exception e捕获不到，因为是error
            System.out.println("count:"+count);
            e.printStackTrace();
        }*/

        try {
            while (true){
                list.add(new CheckOOM());
                count++;
            }
        } catch (OutOfMemoryError e) {
            //Exception e捕获不到，因为是error
            System.out.println("count:"+count);
            e.printStackTrace();
        }
    }
}
