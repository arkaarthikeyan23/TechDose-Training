import java.util.Scanner;

public class binarySearch {

    public static int bsearch(int[] arr,int key){
        int low=0, high=arr.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid] == key){
                return mid;
            }
            else if(arr[mid]<key){
                low = mid+1;
            }
            else{
                high =mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        int index = bsearch(arr,key);
        if(index >= 0){
            System.out.printf("%d is found at index %d",key,index);
        }
        else{
            System.out.println(key+" is not found");
        }
        sc.close();
    }
}
