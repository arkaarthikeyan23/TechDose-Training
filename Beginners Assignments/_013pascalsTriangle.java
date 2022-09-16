import java.util.*;
public class _013pascalsTriangle {
    public static void printPascalsTriangle(int n){
        int[][] pascal = new int[n+1][n+1];
        pascal[0][0] = 1;
        for(int i=1; i<=n; i++){
            pascal[i][0] = 1;
            pascal[i][i] = 1;
            for(int j=1; j<i; j++){
                pascal[i][j] = pascal[i-1][j-1]+pascal[i-1][j];
            }
        } 
        for(int i=0; i<=n; i++){
            for(int j=0; j<=i; j++){
                System.out.print(pascal[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        printPascalsTriangle(n);
    }
}
