public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int max_straight_sum = Integer.MIN_VALUE;
        int min_straight_sum = Integer.MAX_VALUE;
        int temp_max_sum=0, temp_min_sum=0;
        int array_sum=0;

        for(int num : nums){
            array_sum += num;

            temp_max_sum += num;
            max_straight_sum = Math.max(temp_max_sum, max_straight_sum);
            temp_max_sum = temp_max_sum<0 ? 0 : temp_max_sum;

            temp_min_sum += num;
            min_straight_sum = Math.min(temp_min_sum, min_straight_sum);
            temp_min_sum = temp_min_sum>0 ? 0 : temp_min_sum;
        }
        if(min_straight_sum == array_sum){//arr contains only -ve elements
            return max_straight_sum;
        }
        return Math.max(max_straight_sum, (array_sum - min_straight_sum));
    }
}
