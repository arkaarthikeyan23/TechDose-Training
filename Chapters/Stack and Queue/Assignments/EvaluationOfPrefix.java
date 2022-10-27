import java.util.Scanner;
import java.util.Stack;
public class EvaluationOfPrefix {
    //Same as evaluation of postfix , here we traverse from right to left
    static int evaluate_Prefix(String prefix){
        Stack<Integer> stk = new Stack<>();
        int n = prefix.length();
        for(int i=n-1; i>=0; i--){
            char ch = prefix.charAt(i);
            //If operand push to stack as integer
            if(ch>='0' && ch<='9'){
                stk.push(ch-'0');
            }
            else{
                //Interchange 
                int val2 = stk.pop();
                int val1 = stk.pop();
                switch(ch){
                    case '+':
                        stk.push(val2+val1);
                        break;
                    case '-':
                        stk.push(val2-val1);
                        break;
                    case '*':
                        stk.push(val2*val1);
                        break;
                    case '/':
                        stk.push(val2/val1);
                        break;
                    case '%':
                        stk.push(val2%val1);
                        break;
                }
            }
        }
        return stk.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String prefix  = sc.next();
        sc.close();
        System.out.println("Result is :"+evaluate_Prefix(prefix));
    }    
}
