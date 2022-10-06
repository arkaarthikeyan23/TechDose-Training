public class majorityElement {
    public int getMajorityElement(int[] nums) {
        int majority=nums[0], count=1;
        for(int i=1; i<nums.length; i++){
            if(nums[i]==majority){
                count++;
            }
            else{
                count--;
                if(count==0){
                    majority = nums[i];
                    count=1;
                }
            }
        }
        return majority;
    }
}
