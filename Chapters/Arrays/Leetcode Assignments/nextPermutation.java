import java.util.*;
public class nextPermutation {
    public void nextPermutation1(int[] nums) {
        int n = nums.length;
        if(n==1)
            return;
        int i=1, peakIndex=-1;
        while(i<n){
            if(nums[i]>nums[i-1]){
                peakIndex=i;
            }
            i++;
        }
        //Check if arr is DESC
        if(peakIndex==-1){
            Arrays.sort(nums);
            return;
        }
        //Find elements in the range (nums[peakIndex-1] to nums[peakIndex]) to the right
        //int peakElement = nums[peakIndex];
        int index = peakIndex;
        for(i=peakIndex; i<n; i++){
            if(nums[i]>nums[peakIndex-1] && nums[i]<nums[index]){
                index = i;
            }
        }
        //swap
        int temp = nums[peakIndex-1];
        nums[peakIndex-1] = nums[index];
        nums[index] = temp;
        //sort from peakIndex
        Arrays.sort(nums,peakIndex,n);
        return;
        
    }
}