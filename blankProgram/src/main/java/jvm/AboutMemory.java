package jvm;

//-Xms16m -Xmx8m -XX:+PrintGCDetails:没调出来OOM
public class AboutMemory {

    public static void main(String[] args) {
        //返回虚拟机试图使用的最大内存
        long max = Runtime.getRuntime().maxMemory();

        //返回java的总内存
        long total = Runtime.getRuntime().totalMemory();

        System.out.println("max=" + max + "字节\t" + (max / (double) 1024 / 1024) + "MB");
        System.out.println("total=" + total + "字节\t" + (total / (double) 1024 / 1024) + "MB");

        //默认情况下：分配的总内存是电脑内存的1/4，而初始化的内存：1/64

        //-Xms1024m -Xmx1024m -XX:+PrintGCDetails1
        //PSYoungGen  ParOldGen   Metaspace
        //OOM解决：
            //1.尝试扩大堆内存看结果
            //2.分析内存，看那个地方出现问题(专业工具)

    }
}
