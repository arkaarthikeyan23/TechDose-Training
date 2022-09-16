public class _024sqrtOfNum {
    //TC : O(log(N)) SC : O(1)
    public int mySqrt(int x) {
        if(x<=1)
            return x;
        int left=1, right=x-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(mid == x/mid){
                return mid;
            }
            else if(mid < x/mid){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return right;
    }
}
