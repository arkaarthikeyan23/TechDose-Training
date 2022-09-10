import java.util.*;
public class selectionSort {
    /*
    Time Complexity:
    Best Case : O(n^2)
    Worst Case : O(n^2) 
    */
    public static void sort(int[] arr){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            int minIndex=i;
            for(int j=i+1; j<n; j++){
                if(arr[minIndex]>arr[j]){
                    minIndex = j;
                }
            }
            //Swapping  
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
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
