/*public class maxSumSubarray {
    //Kadane's Algorithm
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i=0; i<nums.length; i++){
            currSum += nums[i];
            maxSum = Math.max(maxSum,currSum);
            if(currSum<0){
                currSum=0;
            }
        }
        return maxSum;
    }
}*/
//Follow up : Find the subarray
public class maxSumSubarray{
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        int start=0, end=0;
        for(int i=0; i<n; i++){
            currSum+=arr[i];
            if(currSum > maxSum){
                maxSum = currSum;
                end = i;
            }
            if(currSum<0){
                currSum=0;
                start = i+1;
            }
        }
        System.out.println("Maximum Sum : "+maxSum);
        for(int i=start; i<=end; i++){
            System.out.print(arr[i]+" ");
        }
    }
}
