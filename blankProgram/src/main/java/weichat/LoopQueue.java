package weichat;

//循环队列
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;//队列中元素个数

    //队列中元素个数
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    //入队列操作
    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            //队列已满，需要扩容
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    //出队操作
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        E ret = data[front];
        data[front] = null;//手动释放

        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity()/2);
        }
        return ret;
    }

    //获取队首元素
    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        return data[front];
    }

    //构造函数，传入队列的容量capacity构造函数
    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    //无参构造函数，默认队列的容量capacity=10
    public LoopQueue() {
        this(10);
    }

    //真正容量
    public int getCapacity() {
        return data.length - 1;
    }

    //改变容量
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];//循环数组防止越界
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue:size=%d,capacity=%d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(",");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<Integer>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i%3==2){//每添加3个元素出列一个
                queue.dequeue();
                System.out.println(queue);
            }

        }
    }
}
