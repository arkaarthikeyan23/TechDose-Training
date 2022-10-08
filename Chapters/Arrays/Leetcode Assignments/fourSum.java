import java.util.*;
public class fourSum {
    public List<List<Integer>> getFourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n-3; i++){
            if(i!=0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1; j<n-2; j++){
                if(j!=i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int left=j+1, right=n-1;
                long remainingSum = (long)target - nums[i] - nums[j];
                while(left<right){
                    if(remainingSum == nums[left]+nums[right]){
                        set.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++; 
                        right--;
                    }
                    else if(nums[left]+nums[right] < remainingSum){
                        left++;
                    }
                    else{
                        right--;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
}
