import java.util.*;
// Catalan Number: 2nCn/n+1
public class catalanNumber {
    //Recursive TC:Exponential
    public static int getNthCatalanNumber1(int n){
        int result=0;
        if(n==0 || n==1)
            return 1;
        for(int i=0; i<n; i++){
            result += getNthCatalanNumber1(i) * getNthCatalanNumber1(n-i-1);
        }
        return result;
    }
    //Dynamic Programming  TC:O(n*n)
    public static int getNthCatalanNumber2(int n){
        int[] catalanNumbers = new int[n+1];
        catalanNumbers[0] = catalanNumbers[1] = 1;
        for(int i=2; i<=n; i++){
            for(int j=0; j<i; j++){
                catalanNumbers[i] += catalanNumbers[j] * catalanNumbers[i-j-1];
            }
        }
        return catalanNumbers[n];
    }
    /*Binomial Coefficient
    public static int binomialCoefficient(int n, int k){
        int result=1;
        //since C(n,k) = C(n,n-k)
        if(k > n-k){
            k = n-k;
        }
        // calculate the value of [n*(n-1)*...*(n-k+1)] / [k*(k-1)*...*1]
        for(int i=0; i<k; i++){
            result *= (n-i);
            result /= (i+1);
        }
        return result;
    }*/
    //TC:O(n)
    public static int getNthCatalanNumber3(int n){
        //Calculate value of 2nCn
        int[][] biCoeff = new int[2 * n + 1][n + 1]; 
        for (int i = 0; i <= 2 * n; i++) {
            for (int j = 0; j <= Math.min(i, n); j++) {
                if (i == 0 || j == 0)
                    biCoeff[i][j] = 1;
                else
                    biCoeff[i][j] = biCoeff[i - 1][j] + biCoeff[i - 1][j - 1];
            }
        }

        //return 2nCn/(n+1)
        return biCoeff[2*n][n]/(n+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getNthCatalanNumber1(n));
        System.out.println(getNthCatalanNumber2(n));
        System.out.println(getNthCatalanNumber3(n));
        sc.close();
    }
}
