public class MinimumSwapsToGroupOnes2134 {
    //Sliding Window
    public int minSwaps(int[] nums) {
        int n = nums.length; 
        int[] circular = new int[2*n];
        int totalOnes = 0;
        for(int i=0; i<n; i++){
            totalOnes+=nums[i];//window length
            circular[i] = nums[i];
            circular[n+i] = nums[i];
        }
        int start=0, end=0;
        int zerosCount=0, minZeros = Integer.MAX_VALUE;
        for(; end<totalOnes; end++){
            if(circular[end]==0){
                zerosCount++;
            }
        }
        for(; end<circular.length; end++){
            if(circular[end]==0){
                zerosCount++;
            }
            if(end-start+1 == totalOnes){
                minZeros = Math.min(minZeros,zerosCount);
            }
            else if(end-start+1 > totalOnes){
                if(circular[start]==0){
                    zerosCount--;
                }
                minZeros = Math.min(minZeros,zerosCount);
                start++;
            }
        }
        return minZeros;
    }
}
