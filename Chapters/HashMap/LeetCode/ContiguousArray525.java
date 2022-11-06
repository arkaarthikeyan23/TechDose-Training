import java.util.*;
public class ContiguousArray525{
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum=0, longest_subarray=0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i]==0 ? -1 : 1;
            //subarray starts from 0th index;
            if(sum==0){
                longest_subarray = i+1;
            }
            else if(map.containsKey(sum)){
                longest_subarray = i - map.get(sum);
            }else{
                map.put(sum,i);
            }
        }
        return longest_subarray;
    }
}