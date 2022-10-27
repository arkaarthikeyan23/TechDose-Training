import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix{
    
    //Precedence
    static int precedence(char ch){
       switch(ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
       }
    }
    
    static String infix_to_postfix(String infix){
        String postfix = "";
        int n = infix.length();
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<n; i++){
            char ch = infix.charAt(i);
            //If operand , add to string
            if(Character.isLetterOrDigit(ch)){
                postfix += ch;
            }
            //If '(' , push to stack
            else if(ch=='('){
                stk.push(ch);
            }
            //If ')' , pop all characters until '(' is reached;
            else if(ch==')'){
                while(!stk.isEmpty() && stk.peek()!='('){
                    postfix += stk.pop();
                }
                stk.pop();
            }
            //If operator, push higher precedence operators, else pop
            else{
                while(!stk.isEmpty() && precedence(ch) <= precedence(stk.peek())){
                    postfix += stk.pop();
                }
                stk.push(ch);
            }
        }
        //Pop all characters out of stack
        while(!stk.isEmpty()){
            postfix += stk.pop();
        }
        return postfix;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String infix = sc.next();
        sc.close();
        System.out.println("PostFix Expression : "+infix_to_postfix(infix));
    }
}