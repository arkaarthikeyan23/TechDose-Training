import java.util.*;
public class isPrime {
    //TC:O(n)
    public static boolean isPrime1(int n){
        for(int i=2; i<n; i++){
            if(n%i==0)
                return false;
        }
        return true;
    }

    //TC:O(root(n))
    public static boolean isPrime2(int n){
        for(int i=2; i*i<=n; i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(isPrime1(n)?"Prime":"Not Prime");
        System.out.println(isPrime2(n)?"Prime":"Not Prime");
    }
}
