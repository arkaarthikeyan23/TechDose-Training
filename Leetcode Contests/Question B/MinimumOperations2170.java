public class MinimumOperations2170 {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int[] odd = new int[100001];
        int[] even = new int[100001];
        
        int oddMax=0, oddMaxFreq=0;
        int oddSecondMaxFreq=0;
        
        for(int i=1; i<n; i+=2){
            odd[nums[i]]++;
        }
        for(int i=0; i<odd.length; i++){
            if(odd[i]>oddMaxFreq){
                oddMax = i;
                oddMaxFreq = odd[i];
            }
        }
        for(int i=0; i<odd.length; i++){
            if(odd[i]>oddSecondMaxFreq && i!=oddMax){
                oddSecondMaxFreq = odd[i];
            }
        }
        
        int evenMax=0, evenMaxFreq=0;
        int evenSecondMaxFreq=0;
        
        for(int i=0; i<n; i+=2){
            even[nums[i]]++;
        }
        for(int i=0; i<even.length; i++){
            if(even[i]>evenMaxFreq){
                evenMax = i;
                evenMaxFreq = even[i];
            }
        }
        for(int i=0; i<even.length; i++){
            if(even[i]>evenSecondMaxFreq && i!=evenMax){
                evenSecondMaxFreq = even[i];
            }
        }
        if(oddMax != evenMax){
            return n-oddMaxFreq-evenMaxFreq;
        }
        else{
            return Math.min(n-evenMaxFreq-oddSecondMaxFreq,n-evenSecondMaxFreq-oddMaxFreq);
        }
    }
}
