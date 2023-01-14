
public class MaximumSumIncreasingSubsequence {
    public int maxSumIS(int arr[], int n)  
	{  
	    int[] msis = new int[n];
	    for(int i=0; i<n; i++){
	        msis[i]  = arr[i];
	    }
	    
	    for(int i=1; i<n; i++){
	        for(int j=0; j<i; j++){
	            if(arr[i]>arr[j] && msis[i] < arr[i]+msis[j]){
	                msis[i] = arr[i]+msis[j];
	            }
	        }
	    }
	    int max=0;
	    for(int val : msis){
	        max = Math.max(val, max);
	    }
	    return max;
	}
}
