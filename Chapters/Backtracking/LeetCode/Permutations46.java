import java.util.*;
public class Permutations46 {
    public void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
    
    public void permute(List<List<Integer>> ans, int[] nums, int start, int end){
        if(start==end){
            List<Integer> currList = new ArrayList<>();
            for(int val : nums){
                currList.add(val);
            }
            ans.add(currList);
        }
        for(int i=start; i<=end; i++){
            swap(nums,start,i);//find combinations
            permute(ans, nums, start+1, end);
            swap(nums,start,i);//backtrack
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permute(ans, nums, 0, nums.length-1);
        return ans;
    }
}
//Approach 2:
/*
 * public void solve(List<List<Integer>> ans, List<Integer> ds, boolean[] isTaken, int[] nums){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(!isTaken[i]){
                isTaken[i] = true;
                ds.add(nums[i]);
                solve(ans,ds,isTaken,nums);
                isTaken[i] = false;
                ds.remove(ds.size()-1);
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] isTaken = new boolean[nums.length];
        solve(ans,ds,isTaken,nums);
        return ans;
    }
 */
