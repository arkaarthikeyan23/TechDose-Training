import java.util.*;
public class bubbleSort {
    /*
    Time Complexity
    Best Case : O(N)--> Already sorted Array
    Worst Case : O(N^2)--> Reversely sorted Array
    Average Case : O(N^2)--> Arranged randomly  
    */
    public static void sort(int[] arr){
        int n = arr.length;
        for(int i=n-1; i>0; i--){
            boolean isSwapped=false;
            for(int j=0; j<i; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwapped = true;
                }
            }
            if(isSwapped==false)
                break;
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
        sort(arr);
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
