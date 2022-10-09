import java.util.*;
public class medianOfRowWiseSortedMatrix {

    public static int getCount(int[] arr, int target){
        int low = 0, high = arr.length-1;
        while(low<=high){
            int mid = (low+high) >> 1;
            if(arr[mid]<= target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }

    public static int getMedian(int[][] mat, int m, int n){
        int low = 1, high = (int)1e9;

        while(low<=high){
            int mid = (low+high) >> 1;
            int count=0;
            for(int i=0; i<m; i++){
                count += getCount(mat[i],mid);
            }
            if(count <= (m*n)/2){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt(), n=sc.nextInt();
        int[][] mat = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        sc.close();
        System.out.println(getMedian(mat,m,n));
    }
}
