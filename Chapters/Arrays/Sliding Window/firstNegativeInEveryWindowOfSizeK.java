import java.util.*;
public class firstNegativeInEveryWindowOfSizeK {
    //TC:O(N) SC:O(K)
    public static List<Integer> firstNegativeElement(int[]arr, int k){
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(!dq.isEmpty() && dq.peekFirst() == i-k){
                dq.removeFirst();
            }
            if(arr[i]<0){
                dq.add(i);
            }
            if(i>=k-1){
                result.add(dq.isEmpty()?0:arr[dq.peekFirst()]);
            }
        }
        return result;
    }
    //TC:O(N) SC:O(1)
    public static List<Integer> firstNegativeElement2(int[]arr, int k){
        List<Integer> result = new ArrayList<>();
        int fneIdx=0;//fneIdx - firstNegativeElementIndex
        for(int i=k-1; i<arr.length; i++){
            while(fneIdx<i && (fneIdx<=i-k || arr[fneIdx]>=0)){
                fneIdx++;
            }
            if(arr[fneIdx]<0){
                result.add(arr[fneIdx]);
            }else{
                result.add(0);
            }
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
        int k = sc.nextInt();
        sc.close();
        System.out.println(firstNegativeElement(arr,k));
        System.out.println(firstNegativeElement2(arr,k));
    }
}
