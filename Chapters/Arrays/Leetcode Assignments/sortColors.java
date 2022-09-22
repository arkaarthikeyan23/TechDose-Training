public class sortColors {
    //TC:O(N) SC:O(1)
    public void sortColors1(int[] nums) {
        int zerosIndex=0 , twosIndex=nums.length-1;
        for(int i=zerosIndex; i<=twosIndex;){
            if(nums[i]==0){
                swap(nums,zerosIndex,i);
                zerosIndex++;
                i++;
            }
            else if(nums[i]==2){
                swap(nums,twosIndex, i);
                twosIndex--;
            }
            else{
                i++;
            }
        }
        return;
    }
    public static void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    } 
}
