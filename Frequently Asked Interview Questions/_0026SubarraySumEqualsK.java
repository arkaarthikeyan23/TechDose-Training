import java.util.*;
public class _0026SubarraySumEqualsK
{
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count=0;
        Map<Integer,Integer> map = new HashMap<>();
        int currSum=0;
        for(int i=0; i<n; i++){
            currSum += nums[i];
            if(currSum == k){
                count++;
            }
            if(map.containsKey(currSum-k)){
                count+=map.get(currSum-k);
            }
            map.put(currSum , map.getOrDefault(currSum,0)+1);
        }
        return count;
    }
}