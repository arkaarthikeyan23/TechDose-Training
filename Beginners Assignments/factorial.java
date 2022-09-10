import java.util.*;
public class factorial {
    public static long getFactorial(int n){
        if(n==0){
            return 1;
        }
        int fact=1;
        for(int i=1; i<=n; i++){
            fact = fact*i;
        }
        return fact;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(getFactorial(n));
    }
}
