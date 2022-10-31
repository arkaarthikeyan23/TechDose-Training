
import java.util.*;

import javafx.util.Pair;
public class maxOfMinimumofEvenyWindowSizeOfK {
    public static int[] getMinimumOfsubArrays(int[] a,int n, int k){
        int[] result = new int[n-k+1];
        int index=0;
        Deque<Pair<Integer,Integer>> dq = new LinkedList<>();
        for(int i=0; i<n; i++){
            //remove front element
            if(!dq.isEmpty() && dq.peekFirst().getValue() <= (i-k)){
                dq.removeFirst();
            }
            //Maintain elements in ASC order
            while(!dq.isEmpty() && a[i] < dq.peekLast().getKey()){
                dq.removeLast();
            }
            //Push curr NODE
            dq.addLast(new Pair<>(a[i],i));
            //get minimum of every window
            if(i>=(k-1)){
                result[index++] = dq.peekFirst().getKey();
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
        int[] minimum = getMinimumOfsubArrays(arr,n,k);
        int max = minimum[0];
        for(int i=1; i<minimum.length; i++){
            max = Math.max(max,minimum[i]);
        }
        System.out.println(max);
    }
}
