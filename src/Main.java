public class Main {
    public static void main(String[] args){
        int[] ls = {3, 1, 4, 2};
        for(int i : heapSort(ls)){
            System.out.println(i);
        }
    }
    public static int[] heapSort(int[] ls){
        Heap heap = new Heap(ls, true);
        heap.buildHeap();
        while(heap.length > 1){
            int temp  = heap.ls[heap.length - 1];
            heap.ls[heap.length - 1] = heap.ls[0];
            heap.ls[0] = temp;
            heap.length--;
            heap.heapify(1);
        }
        return heap.ls;
    }
    public static void quickSort(int[] ls){
        quickSort(ls, 0, ls.length - 1);
    }
    public static void quickSort(int[] ls, int left, int right){
        if(left < right){
            int pivot = partition(ls, left, right);
            quickSort(ls, left, pivot - 1);
            quickSort(ls, pivot + 1, right);
        }
    }
    public static int partition(int[] ls, int left, int right){
        int pos = left;
        for(int i = left; i < right; i++){
            if(ls[i] < ls[right]){
                int temp = ls[i];
                ls[i] = ls[pos];
                ls[pos] = temp;
                pos++;
            }
        }
        int temp = ls[pos];
        ls[pos] = ls[right];
        ls[right] = temp;
        return pos;
    }
    public static void mergeSort(int[] ls){
        mergeSort(ls, 0, ls.length - 1);
    }
    public static void mergeSort(int[] ls, int left, int right){
        if(left < right){
            int middle = (left + right) / 2;
            mergeSort(ls, left, middle);
            mergeSort(ls, middle + 1, right);
            merge(ls, left, middle, right);
        }
    }
    public static void merge(int[] ls, int left, int middle, int right){
        int[] result = new int[right - left + 1];
        int i = left;
        int j = middle + 1;
        int k = 0;
        while(i <= middle && j <= right){
            if(ls[i] <= ls[j]){
                result[k] = ls[i];
                i++;
            }else{
                result[k] = ls[j];
                j++;
            }
            k++;
        }
        if(i <= middle){
            while(i <= middle){
                result[k] = ls[i];
                i++;
                k++;
            }
        }else{
            while(j <= right){
                result[k] = ls[j];
                j++;
                k++;
            }
        }
        for(i = 0; i < result.length; i++){
            ls[i + left] = result[i];
        }
    }
}