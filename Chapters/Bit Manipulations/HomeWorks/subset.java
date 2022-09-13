import java.util.*;
public class subset {
    public static void getPossibleSubset(List<List<Integer>> result, int n, int[] arr){
        for(int i=0; i<(1<<n); i++){
            List<Integer> currSet = new ArrayList<>();
            for(int j=0; j<n; j++){
                if((i & (1<<j) )>0){
                    currSet.add(arr[j]);
                }
            }
            result.add(currSet);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        List<List<Integer>> result = new ArrayList<>();
        getPossibleSubset(result, n, arr);
        System.out.println(result);
    }
}
