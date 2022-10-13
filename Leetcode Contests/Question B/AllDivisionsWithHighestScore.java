import java.util.*;
public class AllDivisionsWithHighestScore {
    public List<Integer> maxScoreIndices(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int ones=0;
        for(int val : nums){
            ones+=val;
        }
        int leftScore=0, rightScore=ones;
        int maxScore = leftScore + rightScore;
        ans.add(0);
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                leftScore++;
            }else if(nums[i]==1){
                rightScore--;
            }
            int currScore = leftScore + rightScore;
            if(currScore > maxScore){
                ans = new ArrayList<>();
                ans.add(i+1);
                maxScore = currScore;
            }
            else if(currScore == maxScore){
                ans.add(i+1);
            }
        }
        return ans;
    }
}
