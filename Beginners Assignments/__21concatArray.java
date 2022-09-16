public class __21concatArray {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] concatArr = new int[2*nums.length];
        for(int i=0; i<concatArr.length; i++){
            concatArr[i] = nums[i%n];
        }
        return concatArr;
    }
}
