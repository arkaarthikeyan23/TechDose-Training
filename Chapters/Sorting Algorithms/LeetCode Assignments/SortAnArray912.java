import java.util.Random;
public class SortAnArray912 {
    public void random(int[] nums, int low, int high){
        Random rand = new Random();
        int pivot = rand.nextInt(high-low)+low;
        int temp = nums[pivot];
        nums[pivot] = nums[high];
        nums[high] = temp;
    }
    
    public int partition(int[] nums, int low, int high){
        random(nums,low,high);//Choose pivot randomly
        
        int pivot = nums[high];
        
        int i = low-1;//index for smaller element
        for(int j=low; j<high; j++){
            if(nums[j] < pivot){
                i++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[i+1];
        nums[i+1] = nums[high];
        nums[high] = temp;
        
        return i+1;
    }
    
    public void quicksort(int[] nums, int low, int high){
        if(low<high){
            int partitionIndex = partition(nums,low,high);
            quicksort(nums,low,partitionIndex-1);
            quicksort(nums,partitionIndex+1,high);
        }
    }
    
    public int[] sortArray(int[] nums) {
        quicksort(nums,0,nums.length-1);
        return nums;
    }
}
