public class Heap {
    public int[] ls;
    public int length;
    private boolean max;
    public Heap(int[] ls, boolean max){
        this.ls = ls;
        this.length = ls.length;
        this.max = max;
    }
    public Heap(int length, boolean max){
        ls = new int[length];
        this.length = 0;
        this.max = max;
    }
    public void buildHeap(){
        for(int i = length; i >= 1; i--){
            heapify(i);
        }
    }
    public void heapify(int v){
        int next = v;
        if(max){
            if(2*v <= length){
                if(ls[next - 1] < ls[2*v - 1]){
                    next = 2*v;
                }
            }
            if(2*v + 1 <= length) {
                if (ls[next - 1] < ls[2 * v]) {
                    next = 2 * v + 1;
                }
            }
        }else{
            if(2*v <= length){
                if(ls[next - 1] > ls[2*v - 1]){
                    next = 2*v;
                }
            }
            if(2*v + 1 <= length){
                if(ls[next - 1] > ls[2*v]){
                    next = 2*v + 1;
                }
            }
        }
        if(next != v){
            int temp = ls[v - 1];
            ls[v - 1] = ls[next - 1];
            ls[next - 1] = temp;
            heapify(next);
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
            if((ls[v - 1] > ls[parent - 1] && max) || (ls[v - 1] < ls[parent - 1] && !max)){
                if(ls[v - 1] > ls[parent - 1]){
                    int temp = ls[v - 1];
                    ls[v - 1] = ls[parent - 1];
                    ls[parent - 1] = temp;
                    filterUp(parent);
                }
            }
        }
    }
}
