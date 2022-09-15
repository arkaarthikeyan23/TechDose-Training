import java.util.*;

public class quickSort{
    //last element as partition 
    public static int partition(int[] arr, int low, int high){
            int pivot = arr[high];
            int i = low-1; // pointing position of the pivot
            for(int j=low; j<=high-1; j++){
                //if curr element is less than pivot , increment i, swap a[i]&a[j]
                if(arr[j] < pivot){
                    i++;
                    //swap
                    int temp = arr[i];
                    arr[i]  = arr[j];
                    arr[j] = temp;
                }
            }
            //position the pivot element 
            int temp = arr[i+1];
            arr[i+1] = pivot;
            arr[high] = temp;
            return i+1;
    }

    public static void sort(int[] arr, int low, int high){
        if(low < high){
            int pi = partition(arr,low,high);//pi->partition index
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for(int i=0; i<n; i++){
            arr[i]  = sc.nextInt();
        }
        sc.close();
        sort(arr,0,n-1);
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
/*
 * BC : O(Nlog(N)) --> Partioning done in middle element 
 * WC : O(N^2) --> Array sorted in ascending order(to improve this go for randomized quick sort)
 * Quick sort is inplace sorting (i.e doesn't take extra space)
 */