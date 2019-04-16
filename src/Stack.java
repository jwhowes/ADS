public class Stack<E>{
    private class Node{
        Node next;
        E data;
        Node(E data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    private Node head;
    public Stack(){
        head = null;
    }
    public void push(E data){
        head = new Node(data, head);
    }
    public void pushFrom(E[] items){
        for(E item : items){
            push(item);
        }
    }
    public E pop(){
        if (!isEmpty()) {
            E data = head.data;
            head = head.next;
            return data;
        }
        return null;
    }
    public boolean isEmpty(){
        return head == null;
    }
}
