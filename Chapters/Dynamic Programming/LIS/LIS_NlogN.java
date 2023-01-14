public class LIS_NlogN{
    // Binary search (note boundaries in the caller)
    // A[] is ceilIndex in the caller
    public static int ceilIndex(int[] arr, int n, int key){

        int left=0, right=n-1;

        while(left  < right){
            int mid = left + (right-left)/2;
            if(arr[mid] < key){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }

    public static int LIS_length(int[] arr, int n){
        int[] tailTable = new int[n];//To store the end elements
        int len=1;//Length of LIS

        tailTable[0] = arr[0];
        for(int i=1; i<n; i++){
            if(arr[i] < tailTable[0]){// new smallest value
                tailTable[0] = arr[i];
            }
            else if(arr[i] > tailTable[len-1]){
                tailTable[len++] = arr[i];// arr[i] wants to extend largest subsequence
            }
            // A[i] wants to be current end candidate of an existing
            // subsequence. It will replace ceil value in tailTable
            else{
                tailTable[ceilIndex(arr, len, arr[i])] = arr[i];
            }
        }
        return len;
    }

    public static void main(String[] args){
        int[] arr = {2, 5, 3, 7, 11, 8, 10, 13, 6};
        int n = arr.length;
        System.out.println(LIS_length(arr, n));
    }
}