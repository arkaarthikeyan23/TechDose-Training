import java.util.*;
public class _10_isPalindrome {
    //TC:O(N)
    public static boolean isPalindrome(String s){
        int start=0;
        int end = s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        System.out.println(isPalindrome(str)?str+" is Palindrome":str+" is not a Palindrome");
    }
}
