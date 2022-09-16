import java.util.*;
public class __14isPerfectSquare {
    //TC:O(root(n))
    public static boolean isSquare1(int n){
        if(n==0){
            return true;
        }
        for(int i=1; i*i<=n; i++){
            if(n%i==0 && (n/i==i)){
                return true;
            }
        }
        return false;
    }
    //Using Binary Search ==> TC:O(log(n))
    public static boolean isSquare2(int n){
        if(n==0){
            return true;
        }
        int left=1, right=n;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(mid*mid == n)
                return true;
            else if(mid*mid < n){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(isSquare1(n)?n+" is Perfect square":n+" is not a Perfect square");
        System.out.println(isSquare2(n)?n+" is Perfect square":n+" is not a Perfect square");
    }
}
