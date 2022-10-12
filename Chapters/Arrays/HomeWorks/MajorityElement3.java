//Find the element that occur more than N/K times
import java.util.*;
public class  MajorityElement3 {
    public static List<Integer> getMajorityElement(int[] arr, int k){
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            if(m.getValue() > n/k){
                result.add(m.getKey());
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
        System.out.println(getMajorityElement(arr,k));
    }
}
