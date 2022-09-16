import java.util.*;
public class radixSort {
    //TC :O(N)
    public static int[] sort(int[] arr, int n){
        int max = arr[0];
        for(int i=1; i<n; i++){
            max = Math.max(max,arr[i]);
        }
        int digits = (int)(Math.log10(max)+1);//gives no. of. digits
        for(int place=0; place<=digits; place++){
            int[] count = new int[10];//unit digit ranges from 0-9 
            //step 1
            for(int val : arr){
                int index = (val/(int)Math.pow(10,place))%10;
                count[index]++;
            }
            //step 2
            for(int i=1; i<10; i++){
                count[i] += count[i-1];
            }
            //step 3
            int[] output = new int[n];
            for(int i=n-1; i>=0; i--){
                int index = (arr[i]/(int)Math.pow(10,place))%10;
                output[count[index]-1] = arr[i];
                count[index]--;
            }
            //assigning output to arr
            arr = output;
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        int[] result = sort(arr,n);
        for(int i=0; i<n; i++){
            System.out.print(result[i]+" ");
        }
    }
}
