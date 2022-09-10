import java.util.*;
public class gcd {
    //TC:O(log(n))-->Euclid's Algorithm
    public static int GCD(int a, int b){
        return a==0? b:GCD(b%a,a);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        System.out.println(GCD(a,b));
    }
}
