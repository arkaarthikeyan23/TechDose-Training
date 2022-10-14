import java.util.*;
public class RemovingMinimumNumber2171 {
    public long minimumRemoval(int[] beans) {
        int n = beans.length;
        Arrays.sort(beans);
        long sum=0l, min = Long.MAX_VALUE;
        for(int val : beans){
            sum += val;
        }
        for(int i=0; i<n; i++){
            long curr = sum - ((n-i)*(long)beans[i]);
            min = (long)Math.min(curr, min);
        }
        return min;
    }
}
