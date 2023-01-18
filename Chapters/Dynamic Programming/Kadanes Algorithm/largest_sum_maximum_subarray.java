public class largest_sum_maximum_subarray{
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        int meh=0;//Maximum Ending here
        int msf=Integer.MIN_VALUE;//Maximum So Far

        for(int val : arr){
            meh += val;
            if(meh < val){
                meh = val;
            }
            if(msf < meh){
                msf = meh;
            }
        }
        System.out.println(msf);
    }
}