import java.util.*;
public class AppendKIntegersWithMinimalSum2195 {
    public long minimalKSum(int[] nums, int k) {
        long ans = (long)k*(k+1)/2;
        Set<Integer> set = new HashSet<>();
        int count=0;
        for(int num : nums){
            if(!set.contains(num) && num>=1 && num<=k){
                ans -= (long)num;
                count++;
            }
            set.add(num);
        }
        int start = k+1;
        while(count>0){
            if(!set.contains(start)){
                ans += start;
                count--;
            }
            start++;
        }
        return ans;
    }
}
