import java.util.*;
public class SubArraySumEqualsK560 {
    public int subarraySum(int[] nums, int k) {
        int count=0, currSum=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            currSum+=nums[i];
            if(currSum==k){
                count++;
            }
            if(map.containsKey(currSum-k)){
                count+=map.get(currSum-k);
            }
            map.put(currSum,map.getOrDefault(currSum,0)+1);
        }
        return count;
    }
}
