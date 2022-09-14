public class _23_palindromeNumber {
    public boolean isPalindrome(int x) {
        /*-ve no is not a palindrome
        if last digit is 0, then first digit should be 0 to be a palindrome*/
        if(x<0 || (x%10==0 && x!=0)){
            return false;
        }
        int reversedNum=0;
        //traverse till half of the x
        while(x>reversedNum){
            reversedNum = reversedNum*10 + x%10;
            x/=10;
        }
        /*for odd number of digits the middle element has to be omitted.
        eg: 12321 ==> x = 12 
                      reversedNum = 123
        */
        return x==reversedNum || x==reversedNum/10;
    }
}
