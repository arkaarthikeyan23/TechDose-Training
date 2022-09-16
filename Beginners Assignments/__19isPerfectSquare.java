import java.util.*;
public class __19isPerfectSquare {
    //Binary Search --> O(log(N))
    public static boolean isPerfectSquare(int n){
        int left=1, right=n;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(mid*mid == n){
                return true;
            }
            else if(mid*mid < n){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(n+(isPerfectSquare(n)?" is a Perfect Square":" is not a Perfect Square"));
    }
}
