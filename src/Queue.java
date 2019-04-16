public class Queue<E>{
    private class Node{
        Node next;
        E data;
        Node(E data){
            this.data = data;
            this.next = null;
        }
    }
    private Node head;
    public Queue(){
        head = null;
    }
    public void enqueue(E data){
        if(head == null){
            head = new Node(data);
        }else{
            enqueue(data, head);
        }
    }
    public void enqueueFrom(E[] items){
        for(E item : items){
            enqueue(item);
        }
    }
    private void enqueue(E data, Node node){
        if(node.next == null){
            node.next = new Node(data);
        }else{
            enqueue(data, node.next);
        }
    }
    public E dequeue(){
        if(!isEmpty()){
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
