import java.util.*;
public class QuickSelect
{
    public static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high], i=low-1;
        for(int j=low; j<=high-1; j++){
            if(arr[j]<=pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        return i+1;
    }

    public static int kthSmallestElement(int[] arr, int low, int high, int k){
        //finding partition
        int pi = partition(arr,low,high);
        //if partition index == k then return the element
        if(pi+1 == k){
            return arr[pi];
        }
        // if partition value is less than kth position,
        // search right side of the array.
        else if(pi+1 < k){
            return kthSmallestElement(arr, pi+1, high, k);
        }
        // if partition value is more than kth position,
        // search left side of the array.
        else{
            return kthSmallestElement(arr, low, pi-1, k);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();
        System.out.println(kthSmallestElement(arr,0,n-1,k));
    }
}