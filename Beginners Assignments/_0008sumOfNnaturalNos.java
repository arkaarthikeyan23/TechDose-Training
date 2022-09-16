import java.util.*;
public class _0008sumOfNnaturalNos {
    public static int getSum1(int n){
        int sum=0;
        for(int i=1; i<=n; i++){
            sum+=i;
        }
        return sum;
    }
    //Formula: (n*(n+1))/2
    public static int getSum2(int n){
        return (n*(n+1))/2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(getSum1(n));
        System.err.println(getSum2(n));
    }
}
