import java.util.*;

public class CombinationSum39 {
    public void findCombinations(int index, int[] nums, int target, List<List<Integer>> ans, List<Integer> ds){
        if(index==nums.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(nums[index]<=target){
            ds.add(nums[index]);
            findCombinations(index, nums, target-nums[index], ans, ds);//Picked
            ds.remove(ds.size()-1);
        }
        findCombinations(index+1, nums, target, ans, ds);//Not Picked
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}
