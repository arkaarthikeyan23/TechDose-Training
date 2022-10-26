package LeetCode;
import java.util.*;
public class BasicCalculatorII227 {
    public int calculate(String s) {
        int len = s.length();
        char prevSign = '+';
        int currNum=0;
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i<len; i++){
            char ch = s.charAt(i);
            if(ch>='0' && ch<='9'){
                currNum = (currNum*10) + ch-'0';
            }
            if(isOperator(ch) || i==len-1){
                if(prevSign=='+'){
                    stk.push(currNum);
                }else if(prevSign=='-'){
                    stk.push(-currNum);
                }else if(prevSign=='*'){
                    stk.push(stk.pop() * currNum);
                }else if(prevSign=='/'){
                    stk.push(stk.pop() / currNum);
                }
                currNum=0;
                prevSign = ch;
            }
        }
        int ans=0;
        while(!stk.isEmpty()){
            ans += stk.pop();
        }
        return ans;
    }
    boolean isOperator(char ch){
        return ch=='+' || ch=='-' || ch=='*' || ch=='/';
    }
}
