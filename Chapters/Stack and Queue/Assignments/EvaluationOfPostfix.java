import java.util.Scanner;
import java.util.Stack;
public class EvaluationOfPostfix {
    static int evaluate_Postfix(String postfix){
        Stack<Integer> stk = new Stack<>();
        int n = postfix.length();
        for(int i=0; i<n; i++){
            char ch = postfix.charAt(i);
            //If operand push to stack as integer
            if(ch>='0' && ch<='9'){
                stk.push(ch-'0');
            }
            else{
                int val1 = stk.pop();
                int val2 = stk.pop();
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
        String postfix  = sc.next();
        sc.close();
        System.out.println("Result is :"+evaluate_Postfix(postfix));
    }    
}
