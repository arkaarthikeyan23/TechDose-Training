package Assignments;
public class SumOfNnos {

    public static int sumOfNnos(int n){
        if(n==1){
            return 1;
        }
        return n + sumOfNnos(n-1);
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(sumOfNnos(n));
    }
}
