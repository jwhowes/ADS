public class ArrayStack<E> {
    private E[] data;
    private int front;
    public ArrayStack(int size){
        front = 0;
        data = (E[])(new Object[size]);
    }
    public void push(E item){
        if (!isFull()) {
            data[front++] = item;
        }
    }
    public E pop(){
        if(!isEmpty()){
            return data[--front];
        }
        return null;
    }
    public boolean isEmpty(){
        return front == 0;
    }
    public boolean isFull() {
        return front == data.length;
    }
}
