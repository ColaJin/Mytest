package blankProgram.src.main.java.weichat;

public class FinalReferenceDemo {
    final int[] arrays;
    private FinalReferenceDemo finalReferenceDemo;

    public FinalReferenceDemo(){
        arrays = new int[1];//1
        arrays[0] = 1;      //2
    }

    public void writerOne() {
        finalReferenceDemo = new FinalReferenceDemo();//3
    }

    public void writerTwo() {
        arrays[0] = 2; //4
    }

    public void reader() {
        if (finalReferenceDemo != null) {//5
            int temp = finalReferenceDemo.arrays[0];//6
        }
    }

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                FinalReferenceDemo finalReferenceDemo = new FinalReferenceDemo();
                finalReferenceDemo.writerOne();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                FinalReferenceDemo finalReferenceDemo = new FinalReferenceDemo();
                finalReferenceDemo.writerTwo();
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                FinalReferenceDemo finalReferenceDemo = new FinalReferenceDemo();
                finalReferenceDemo.reader();
            }
        }.start();
    }
}
