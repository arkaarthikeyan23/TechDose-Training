public class kthSmallestNumberInMultiplicationTable {
    public int findKthNumber(int m, int n, int k) {
        int low=1, high=m*n;
        while(low<high){
            int mid = low+(high-low)/2;
            if(getCount(mid,m,n) < k){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return high;
    }
    
    public int getCount(int mid, int m, int n){
        int count=0;
        for(int i=1; i<=m; i++){
            count += Math.min(mid/i,n);
        }
        return count;
    }
}
