import java.util.*;
public class QuickSelect
{
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[high], pivotLoc=low;
        for(int i=low; i<=high; i++){
            // inserting elements of less value
            // to the left of the pivot location
            if(arr[i]<pivot){
                int temp = arr[i];
                arr[i] = arr[pivotLoc];
                arr[pivotLoc] = temp;
                pivotLoc++;
            }
        }
        // swapping pivot to the final pivot location
        int temp = arr[high];
        arr[high] = arr[pivotLoc];
        arr[pivotLoc] = temp;
        return pivotLoc;
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