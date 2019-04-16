public class Heap {
    public int[] ls;
    public int length;
    public Heap(int[] ls){
        this.ls = ls;
        this.length = ls.length;
    }
    public Heap(int length){
        ls = new int[length];
        this.length = 0;
    }
    public void buildHeap(){
        for(int i = length; i >= 1; i--){
            heapify(i);
        }
    }
    public void heapify(int v){
        int largest = v;
        if(2*v <= length){
            if(ls[largest - 1] < ls[2*v - 1]){
                largest = 2*v;
            }
        }
        if(2*v + 1 <= length){
            if(ls[largest - 1] < ls[2*v]){
                largest = 2*v + 1;
            }
        }
        if(largest != v){
            int temp = ls[v - 1];
            ls[v - 1] = ls[largest - 1];
            ls[largest - 1] = temp;
            heapify(largest);
        }
    }
    public void filterUp(int v){
        if(v > 1){
            int parent;
            if(v % 2 == 0){
                parent = v / 2;
            }else{
                parent = (v - 1) / 2;
            }
            if(ls[v - 1] > ls[parent - 1]){
                int temp = ls[v - 1];
                ls[v - 1] = ls[parent - 1];
                ls[parent - 1] = temp;
                filterUp(parent);
            }
        }
    }
}
