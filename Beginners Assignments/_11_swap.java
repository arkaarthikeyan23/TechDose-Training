import java.util.*;
public class _11_swap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt(), num2 = sc.nextInt();
        sc.close();
        //num1=5 num2=3
        System.out.println("After Swapping:");
        num1 = num1^num2;//num1 = (5^3)
        num2 = num1^num2;//num2 = (5^3)^3 ==> num2=5
        num1 = num1^num2;//num1 = (5^3)^5 ==> num1=3
        System.out.println(num1+" "+num2);
    }
}
