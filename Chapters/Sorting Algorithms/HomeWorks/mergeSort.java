import java.util.Scanner;

public class mergeSort {

    public static void merge(int[] arr, int low, int mid, int high){
        int i=low, j=mid+1, index=low;
        int[] mergeArr = new int[high+1];
        while(i<=mid && j<=high){
            if(arr[i]<=arr[j]){
                mergeArr[index++] = arr[i++];
            }
            else{
                mergeArr[index++] = arr[j++];
            }
        }
        for(; i<=mid; i++){
            mergeArr[index++] = arr[i];
        }
        for(; j<=high; j++){
            mergeArr[index++] = arr[j];
        }
        for(i=low; i<=high; i++){
            arr[i] = mergeArr[i];
        }
    }

    public static void sort(int[] arr, int low, int high){
        if(low < high){
            int mid = low + (high-low)/2;
            sort(arr, low, mid);
            sort(arr, mid+1,high);
            merge(arr,low,mid,high);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        sort(arr,0,n-1);
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
/*
 * TC:
 * BC : O(Nlog(N))
 * AC : O(Nlog(N))
 * WC : O(Nlog(N))
 * 
 * SC : O(Nlog(N))
 * Not depend on input nature
 */