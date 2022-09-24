import java.util.*;
public class merge2arrWithoutExtraSpace {
    //TC:O(m*n) SC:O(1);
    public static void merge(int[]arr1, int m, int[]arr2, int n){
        //Traversing list 2 from right to left
        for(int i=n-1; i>=0; i--){
            //to keep track of last element in list1;
            int last = arr1[m-1];
            int j;
            //Traversing list 1 from  second last element (i.e.)right to left
            for(j=m-2; j>=0 && arr1[j]>arr2[i]; j--){
                arr1[j+1] =  arr1[j]; //right shift
            }
            if(j!=m-2 || last>arr2[i]){//j!=m-2 --> atleast one shift happens
                arr1[j+1] = arr2[i];
                arr2[i] = last;//place list 1's high element in list 2  
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[] arr1 = new int[m];
        int[] arr2 = new int[n];
        for(int i=0; i<m; i++){
            arr1[i] = sc.nextInt();
        }
        for(int j=0; j<n; j++){
            arr2[j] = sc.nextInt();
        }
        sc.close();
        merge(arr1,m,arr2,n);
        for(int val : arr1){
            System.out.print(val+" ");
        }
        System.out.println();
        for(int val : arr2){
            System.out.print(val+" ");
        }
    }
}
