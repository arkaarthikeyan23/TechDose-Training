import java.util.*;
/*
 Mean :  Average of all numbers
 Median :
  if n is odd --> return middle element
  if n is even --> return average of two middle elements
 Mode : most occurred elements
 */
public class ___9meanMedianMode {

    public static double getMean(int[] a){
        int n=a.length, sum=0;
        for(int i=0; i<n; i++){
            sum += a[i];
        }
        return (double)(sum/n);
    }

    public static double getMedian(int[] a){
        Arrays.sort(a);
        int n = a.length;
        if(n%2==1){
            return (double)a[n/2];
        }
        return (double)(a[(n-1)/2] + a[n/2])/2.0;
    }

    public static List<Integer> getMode(int[] a){
        int n = a.length;
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> mode = new ArrayList<>();
        for(int i=0; i<n; i++){
            map.put(a[i],map.getOrDefault(a[i], 0)+1);
        }
        int max = Collections.max(map.values());
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            if(max == (int)m.getValue()){
                mode.add(m.getKey());
            }
        }
        return mode;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        System.out.println("Mean : "+getMean(arr));
        System.out.println("Median : "+getMedian(arr));
        System.out.println("Mode : "+getMode(arr));
    }
}
