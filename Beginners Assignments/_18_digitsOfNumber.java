import java.util.*;
public class _18_digitsOfNumber {
    public static void printDigits(int n){
        
        while(n>0){
            System.out.print(n%10+" ");
            n/=10;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        printDigits(N);
    }
}
