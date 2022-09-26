import java.util.*;
public class assignmentProblem {

    public static boolean canAssign(int[] arr, int target, int no_Of_Workers){
        int n = arr.length;
        int sum=0;
        for(int i=0; i<n; i++){
            if(sum+arr[i]>=target){
                sum = (sum+arr[i]==target)?0:arr[i];
                if(no_Of_Workers>0){
                    no_Of_Workers--;
                }
                else{
                    return false;
                }
            }
            else{
                sum += arr[i];
            }
        }
        if(sum<=target && no_Of_Workers>0){
            sum=0;
        }
        return (sum==0)?true:false;
    }

    public static int get(int[] arr, int n, int k){
        int min_value=-1, ans=Integer.MAX_VALUE, max_value=0;
        for(int i=0; i<n; i++){
            min_value = Math.max(min_value,arr[i]);
            max_value += arr[i];
        }
        /*
         * min_value = one worker for each garden(max of all time)
         * max_value = one worker for all garden(sum of all time)
         */
        int low = min_value, high = max_value;
        while(low<=high){
            int mid = low+(high-low)/2;
            //System.out.println(mid+" "+low+" "+high);
            if(canAssign(arr, mid, k)){
                high = mid-1;
                ans = Math.min(ans,mid);
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();
        System.out.println("Minimum assignment : "+get(arr,n,k));
    }
}
