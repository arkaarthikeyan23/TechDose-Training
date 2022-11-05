package Assignments;
import java.util.Scanner;

public class fibonacciBinaryExponentiation {
    
    public static int[][] multiply(int[][] a, int[][] b){
        int[][] res = new int[2][2];
        res[0][0] = a[0][0]*b[0][0] + a[0][1]*b[1][0];
        res[0][1] = a[0][0]*b[0][1] + a[0][1]*b[1][1];
        res[1][0] = a[1][0]*b[0][0] + a[1][1]*b[1][0];
        res[1][1] = a[1][0]*b[0][1] + a[1][1]*b[1][1];
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        if(n==0){
            System.out.println("0");
        }else if(n==1 || n==2){
            System.out.println("1");
        }
        else{
            int[][] prev = {{1,1}, {1,0}};
            int[][] res = {{1,1}, {1,0}};
            for(int i=2; i<n; i++){
                res = multiply(prev,res);
            }
            System.out.println(res[0][0]);
        }
    }
}
