public class minimumSizeSubarraySum {
    //TC:O(N)
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum=0, left=0, right=0;
        int shortestLen = Integer.MAX_VALUE;
        //variable size window --> 2 pointer technique
        while(right<n){
            sum += nums[right]; //currSum
            if(sum>=target){//compress  window from left
                while(sum>=target){
                    sum -= nums[left];
                    left++;
                }
                shortestLen = Math.min(shortestLen,(right-left)+2);
            }
            right++;
        }
        return shortestLen==Integer.MAX_VALUE?0:shortestLen;
    }
}
