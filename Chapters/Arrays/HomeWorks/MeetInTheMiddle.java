import java.util.*;
public class MeetInTheMiddle {
    
    public static int maximumSubset(List<Integer> l1, List<Integer> l2, int target){
        int ans = Integer.MIN_VALUE;
        int n1 = l1.size(), n2 = l2.size();
        Collections.sort(l2);
        for(int i=0; i<n1; i++){
            int x = l1.get(i);
            int low = 0, high = n2-1;
            while(low<=high){
                int mid = low + (high-low)/2;
                int sum = x + l2.get(mid);
                if(sum>target){
                    high = mid - 1;
                }
                else{
                    ans = Math.max(ans,sum);
                    low = mid + 1;
                }
            }
        }
        return ans;
    }

    public static List<Integer> combinationSum(int[] arr, int low, int high){
        List<Integer> result = new ArrayList<>();
        int n = (high-low)+1, index=0;
        int[] nums = new int[n];
        for(int i=low; i<=high; i++){
            nums[index++] = arr[i];
        }
        for(int i=0; i<(1<<n); i++){
            int sum=0;
            for(int j=0; j<n; j++){
                if((i & (1<<j) )!= 0){
                    sum += nums[j];
                }
            }
            result.add(sum);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int sum = sc.nextInt();
        int mid = (n-1)/2;
        sc.close();
        List<Integer> l1 = combinationSum(arr,0,mid);
        List<Integer> l2 = combinationSum(arr,mid+1,n-1);
        System.out.println(l1+" "+l2);
        System.out.println(maximumSubset(l1,l2,sum));
    }
}
