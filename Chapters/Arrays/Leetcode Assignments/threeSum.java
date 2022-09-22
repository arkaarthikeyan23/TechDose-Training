import java.util.*;
public class threeSum {
    public List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            int target = -nums[i];//A+B+C==0  ==> B+C==-A
            int left = i+1;
            int right = nums.length-1;
            while(left < right){
                if(nums[left] + nums[right] == target){
                    List<Integer> subList = new ArrayList<>();
                    subList.add(nums[i]);
                    subList.add(nums[left++]);
                    subList.add(nums[right--]);
                    result.add(subList);
                }
                else if(nums[left] + nums[right] < target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
