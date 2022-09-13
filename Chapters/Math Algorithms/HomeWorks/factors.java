import java.util.*;
public class factors{
    //TC:O(n)
    public static List<Integer> getFactors1(int n){
        List<Integer> list = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(n%i==0){
                list.add(i);
            }
        }
        return list;
    }
    
    //TC:O(root(n))
    public static List<Integer> getFactors2(int n){
        List<Integer> list = new ArrayList<>();
        for(int i=1; i*i<=n; i++){
            if(n%i==0){
                list.add(i);
                if(n/i != i){
                    list.add(n/i);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        List<Integer> result = new ArrayList<>();
        result = getFactors1(n);
        System.out.println(result);
        result = getFactors2(n);
        System.out.println(result);
    }
}