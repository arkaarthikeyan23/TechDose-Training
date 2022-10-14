public class MinimumTimeToCompleteTrips2187 {
    public long minimumTime(int[] time, int totalTrips) {
        long left=1;
        long min = time[0];
        for(int val : time){
            min = Math.min(val,min);
        }
        long right = min*totalTrips;
        while(left < right){
            long mid = left + (right-left)/2;
            long total = tripsAtGivenTime(time,mid);
            if(total < totalTrips){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
    public long tripsAtGivenTime(int[] times, long mid){
        long totalTrips=0l;
        for(int time : times){
            totalTrips += (mid/(long)time);
        }
        return totalTrips;
    }
}
