public class ArrayQueue<E>{
    private E[] data;
    private int front;
    private int back;
    private boolean empty;
    public ArrayQueue(int size){
        front = 0;
        back = 0;
        empty = true;
        data = (E[])(new Object[size]);
    }
    public void enqueue(E item){
        if(!isFull()){
            data[front] = item;
            front = (front + 1) % data.length;
            empty = false;
        }
    }
    public E dequeue(){
        if(!isEmpty()){
            E item = data[back];
            back = (back + 1) % data.length;
            empty = (front == back);
            return item;
        }
        return null;
    }
    public boolean isFull(){
        return !empty && front == back;
    }
    public boolean isEmpty(){
        return empty;
    }
}
