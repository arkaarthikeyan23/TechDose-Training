public class CapacityToShipPackagesWithinDdays1011 {
    public int shipWithinDays(int[] weights, int days) {
        int low=Integer.MIN_VALUE, high=0;
        for(int weight : weights){
            low = Math.max(low,weight);
            high += weight;
        }
        int ans=0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(check(mid,days,weights)){
                ans=mid;
                high=mid-1;
            }else{
                low++;
            }
        }
        return ans;
    }
    public boolean check(int target, int days, int[] weights){
        int days_Needed = 1, sum=0;
        for(int i=0; i<weights.length; i++){
            if(sum+weights[i]<=target){
                sum+=weights[i];
            }else{
                sum = weights[i];
                days_Needed++;
            }
        }
        return days_Needed<=days;
    }
}
