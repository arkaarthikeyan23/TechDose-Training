import java.util.Stack;

public class _0017BasicCalculator {
    public int calculate(String s) {
        int len = s.length();
        int ans=0, currNum=0,sign=1;
        Stack<Integer>stk = new Stack<>();
        for(int i=0; i<len; i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                currNum = s.charAt(i)-'0';
                while(i+1<len && (s.charAt(i+1)>='0' && s.charAt(i+1)<='9')){
                    currNum = (currNum*10) + s.charAt(i+1)-'0';
                    i++;
                }
                currNum = currNum*sign;
                ans = ans + currNum;
                currNum=0;
                sign=1;
            }else if(s.charAt(i)=='+'){
                sign=1;
            }else if(s.charAt(i)=='-'){
                sign=-1;
            }else if(s.charAt(i)=='('){
                stk.push(ans);
                stk.push(sign);
                ans=0;
                sign=1;
            }else if(s.charAt(i)==')'){
                int prevSign = stk.pop();
                ans = ans*prevSign;
                int prevAns = stk.pop();
                ans = ans + prevAns;
            }
        }
        return ans;
    }
}
