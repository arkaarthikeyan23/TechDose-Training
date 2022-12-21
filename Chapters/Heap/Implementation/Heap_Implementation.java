package Chapters.Heap.Implementation;
//MAX HEAP  (1 index based array)
class Heap{
    //TC:O(logN)
    static void heapify(int[] arr, int N, int index){
        int largest = index;
        int left = 2*index;
        int right = 2*index+1;

        if(left<N && arr[left] > arr[largest]) largest = left;
        if(right<N && arr[right] > arr[largest]) largest = right;

        if(largest != index){
            swap(arr, largest, index);
            heapify(arr, N, index);
        }
    }
    //TC:O(N)
    static void build_Heap(int[] arr, int N){
        for(int index=N/2; index>=1; index--){
            heapify(arr,N,index);
        }
    }
    //TC:O(logN)
    static void perculate_Up(int[] arr, int N, int index){
        while(index>1 && arr[index/2] < arr[index]){
            swap(arr, index/2, index);
            index = index/2;
        }
    }

    static void perculate_Down(int[] arr, int N, int index){
        heapify(arr, N, index);
    }
    //TC:O(logN)
    static void heap_push(int[] arr, int N, int value){
        arr[N++] = value;
        perculate_Up(arr, N, N-1);
    }
    //TC:O(logN)
    static int heap_pop(int[] arr, int N){
        int max = arr[1];
        arr[1] = arr[N-1];
        N--;
        perculate_Down(arr, N, 1);
        return max;
    }
    //TC:O(logN)
    static void increase_Key(int[] arr, int N, int index, int diff){
        if(diff<0){
            return;
        }
        arr[index]+=diff;
        perculate_Up(arr, N, index);
    }
    //TC:O(logN)
    static void decrease_Key(int[] arr, int N, int index, int diff){
        if(diff>0){
            return;
        }
        arr[index]+=diff;
        perculate_Down(arr, N, index);
    }
    //TC:O(NlogN)  SC:O(logN)
    static int[] heap_sort(int[] arr, int N){
        build_Heap(arr, N);
        int heapSize = N;
        int[] result = new int[N-1];
        for(int i=N-1; i>=1; i--){
            result[i-1] = heap_pop(arr,heapSize);
            heapSize--;
        }
        return result; 
    }

    static void swap(int[] arr, int parent, int child){
        int temp = arr[parent];
        arr[parent] = arr[child];
        arr[child] = temp;
    }
}

public class Heap_Implementation {
    public static void main(String[] args) {
        int[] arr = {0,8,6,9,3,4,2,1};
        int[] result = Heap.heap_sort(arr, arr.length);
        for(int i=0; i<result.length; i++){
            System.out.print(result[i]+" ");
        }
    }
}
