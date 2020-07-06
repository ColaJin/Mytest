package weichat;

public interface Queue<E> {

    //数组队列中元素个数
    int getSize();

    //队列中元素是否为空
    boolean isEmpty();

    //入队列
    void enqueue(E e);

    //出队列
    E dequeue();

    //获取队首元素
    E getFront();
}
