import java.util.*;
public class bucketSort {
    public static int[] sort(int[] arr, int n){
        List<List<Integer>> buckets = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            max = Math.max(max,arr[i]);
        }
        //creating buckets
        for(int i=0; i<=max; i++){
            buckets.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            buckets.get(arr[i]).add(arr[i]);
        }

        int index=0;
        for(int i=0; i<=max; i++){
            for(int j=0; j<buckets.get(i).size(); j++){
                arr[index++] = buckets.get(i).get(j); 
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        int[] result = sort(arr,n);
        for(int i=0; i<n; i++){
            System.out.print(result[i]+" ");
        }
    }
}
