public class largestSubarraySumAtmostK {
    public static int getLargestSubArray(int[] nums, int k){
        int n = nums.length;
        int left=0, right=0, currSum=0;
        int maxSize = Integer.MIN_VALUE;
        while(right<n){
            currSum += nums[right++];
            if(currSum>k){
                currSum -= nums[left++];
            }
            maxSize = Math.max(maxSize,(right-left)+1);
        }
        return maxSize;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        int sum = 7;
        System.out.println(getLargestSubArray(arr,sum));
    }
}
