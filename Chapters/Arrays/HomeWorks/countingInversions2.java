/*
Inversions: A pair (A[i], A[j]) is said to be in inversion if:
A[i] > A[j]
i < j
*/
public class countingInversions2 {
    //Brute Force-->O(N^2)
    public static int getInversions1(int[] nums){
        int count=0, n = nums.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(nums[i]>nums[j]){
                    count++;
                }
            }
        }
        return count;
    }
    //Merge sort-->O(NlogN)
    static int inversionCount=0;
    public static void merge(int[] arr, int low, int mid, int high){
        int left=low, right=mid+1;
        while(left<=mid && right<=high){
            if(arr[left]>arr[right]){
                inversionCount += (mid-left)+1;
                right++;
            }
            else{
                left++;
            }
        }
        if((high-low)==1){
            int e1=arr[low], e2=arr[high];
            arr[low] = Math.min(e1,e2);
            arr[high] = Math.max(e1,e2);
            return;
        }
        for(int i=high; i>mid; i--){
            int last=arr[mid];
            int j;
            for(j=mid-1; j>=low && arr[j]>arr[i]; j--){
                arr[j+1] = arr[j];
            }
            if(last > arr[i]){
                arr[j+1] = arr[i];
                arr[i] = last;
            }
        }
    }

    public static void mergeSort(int[] arr, int low, int high){
        if(low<high){
            int mid = low+(high-low)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }
    public static void main(String[] args) {
        int[] arr = {6,3,5,2,7};
        //System.out.println(getInversions1(arr));
        mergeSort(arr,0,arr.length-1);
        System.out.println(inversionCount);
    }
}
