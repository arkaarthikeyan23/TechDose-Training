import java.util.*;
public class majorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            if(m.getValue() > n/3){
                result.add(m.getKey());
            }
        }
        return result;
    }
}
