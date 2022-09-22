import java.util.*;
public class twoSum {
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            else{
                map.put(nums[i],i);
            }
        }
        //If no pair exits
        return new int[]{};
    }
}
