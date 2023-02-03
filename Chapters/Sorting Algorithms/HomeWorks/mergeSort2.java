import java.util.Scanner;

public class mergeSort2 {
    //wihtout using extra space
    public static void merge(int[] arr, int low, int mid, int high){
                
        for(int i=high; i>=mid+1; i--){
            int j;
            int last = arr[mid];
            for(j=mid-1; j>=low && arr[j]>arr[i]; j--){
                arr[j+1] = arr[j];
            }
            if(j!=mid-1 || last>arr[i]){
                arr[j+1] = arr[i];
                arr[i] = last;
            }
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
