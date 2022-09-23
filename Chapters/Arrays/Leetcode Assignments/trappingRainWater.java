public class trappingRainWater {
    //TC:O(N) SC:O(N)
    public int trap1(int[] height) {
        int n = height.length;
        int[]maxLeft = new int[n];
        int[]maxRight = new int[n];
        int leftMax=0, rightMax=0;
        for(int i=0; i<n; i++){
            maxLeft[i] = Math.max(height[i],leftMax);
            leftMax = Math.max(leftMax,height[i]);
        }
        for(int i=n-1; i>=0; i--){
            maxRight[i] = Math.max(height[i],rightMax);
            rightMax = Math.max(rightMax,height[i]);
        }
        int trappedWater=0;
        for(int i=1; i<n-1; i++){
            trappedWater += (Math.min(maxLeft[i],maxRight[i]) - height[i]);
        }
        return trappedWater;
    }
    //TC:O(N) SC:O(1)
    public int trap2(int[] height) {
        int n = height.length;
        //Base case
        if(n<=2){
            return 0;
        }
        int maxLeft = height[0], maxRight = height[n-1];
        int left = 1, right = n-2;
        int trappedWater=0;
        while(left<=right){
            if(maxLeft < maxRight){
                if(height[left] >= maxLeft){
                    maxLeft = height[left];
                }
                else{
                    trappedWater += (maxLeft - height[left]);
                }
                left++;
            }
            else{
                if(height[right] >= maxRight){
                    maxRight= height[right];
                }
                else{
                    trappedWater += (maxRight - height[right]);
                }
                right--;
            }
        }
        return trappedWater;
    }
}
