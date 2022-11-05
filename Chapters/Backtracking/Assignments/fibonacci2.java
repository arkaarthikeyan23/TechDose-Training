package Assignments;
import java.util.Arrays;
//Recursion + Memoization
public class fibonacci2 {
    static int[] mem = new int[50];
    public static int fib(int n){
        if(mem[n]!=-1){
            return mem[n];
        }
        return fib(n-1) + fib(n-2);
    }
    public static void main(String[] args) {
        int n = 45;
        Arrays.fill(mem,-1);
        mem[0] = 0;
        mem[1] = 1;
        System.out.println(fib(n));
    }
}
