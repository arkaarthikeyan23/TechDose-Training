
import java.util.*;
public class subarrayMaximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sc.close();
        int[] result = new int[n-k+1];
        int index=0;
        LinkedList<Integer> ll = new LinkedList<>();
        for(int i=0; i<n; i++){
            if(!ll.isEmpty() && ll.peekFirst() == i-k){
                ll.pollFirst();
            }
            while(!ll.isEmpty() && arr[ll.peekLast()] <= arr[i]){
                ll.pollLast();
            }
            ll.add(i);
            if(i>=k-1)
                result[index++] = arr[ll.peekFirst()];
        }
        for(int i=0; i<index; i++){
            System.out.print(result[i]+" ");
        }
    }
}
