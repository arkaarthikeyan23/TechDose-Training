public class mergeSort {

    public static void merge(int[] nums, int low, int mid, int high){
        int i=low, j=mid+1, index=low;
        int[] mergeArr = new int[high+1];
        while(i<=mid && j<=high){
            if(nums[i] < nums[j]){
                mergeArr[index++] = nums[i++];
            }
            else{
                mergeArr[index++] = nums[j++];
            }
        }
        while(i<=mid){
            mergeArr[index++] = nums[i++];
        }
        while(j<=high){
            mergeArr[index++] = nums[j++];
        }
        for(i=low; i<=high; i++){
            nums[i] = mergeArr[i];
        }
    }

    public static void sort(int[] arr, int low, int high){
        if(low<high){
            int mid = low + (high-low)/2;
            sort(arr,low,mid);
            sort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,5,3,2,4,7,6};
        sort(arr,0,arr.length-1);
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
