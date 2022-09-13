import java.util.*;
public class insertionSort {
    public static void sort(List<Integer> arr, int val){
        arr.add(val);
        int n=arr.size();
        for(int i=n-1; i>=1; i--){
            if(arr.get(i) > arr.get(i-1)){
                break;
            }
            Collections.swap(arr,i,i-1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int val = sc.nextInt();
            sort(arr, val);
        }
        sc.close();
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
}
/*
TC : 
----
Best Case : O(N) // Array elements are coming in sorted way
Worst Case : O(N^2) // Array sorted in reverse order
Avg Case : O(N^2) // Array in random order
Use Cases
--------
query related problems. eg find median with updating values regularly 
*/