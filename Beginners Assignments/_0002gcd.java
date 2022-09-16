import java.util.*;
public class _0002gcd {
    //Euclidean's Algorithm --> TC:O(log(min(a,b)))
    public static int getGCD(int a, int b){
        if(a==0)
            return b;
        return getGCD(b%a, a);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1=sc.nextInt(), num2=sc.nextInt();
        sc.close();
        System.out.println(getGCD(num1,num2));
    }
}
