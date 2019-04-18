public class PriorityQueue {
    private Heap heap;
    public PriorityQueue(int length){
        heap = new Heap(length, true);
    }
    public void enqueue(int item){
        if(heap.length < heap.ls.length){
            heap.ls[heap.length] = item;
            heap.length++;
            heap.filterUp(heap.length);
        }
    }
    public Integer dequeue(){
        if(heap.length > 0) {
            int result = heap.ls[0];
            heap.ls[0] = heap.ls[heap.length - 1];
            heap.length--;
            heap.heapify(1);
            return result;
        }
        return null;
    }
}