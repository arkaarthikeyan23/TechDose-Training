import java.util.*;
//TC: O(N)
public class _1_secondMax {
    public static int getSecondMax(int[] a){
        int n = a.length;
        int max1 =Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            if(a[i]>max1){
                max2 = max1;
                max1 = a[i];
            }
            else if(a[i]>max2){
                max2 = a[i];
            }
        } 
        return max2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println(getSecondMax(arr));
    }
}
