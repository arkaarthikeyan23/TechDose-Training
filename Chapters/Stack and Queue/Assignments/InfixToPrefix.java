import java.util.Scanner;
import java.util.Stack;
public class InfixToPrefix {

    static int precedence(char ch){
        if(ch=='+' || ch=='-'){
            return 1;
        }else if(ch=='*' || ch=='/'){
            return 2;
        }else if(ch=='^'){
            return 3;
        }else{
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
                while(!stk.isEmpty() && ((ch=='^' && precedence(ch) <= precedence(stk.peek()))
                ||(precedence(ch) < precedence(stk.peek())))){
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

    static String infix_to_prefix(String infix){
        //1)Reverse the infix string 
        String reverse = new StringBuilder(infix).reverse().toString();
        //while reversing if '(' replace ')' and vice versa
        char[] arr =reverse.toCharArray();
        for(int i=0; i<arr.length; i++){
            if(arr[i]=='('){
                arr[i] = ')';
            }else if(arr[i]==')'){
                arr[i] = '(';
            }
        }
        reverse = new String(arr);
        //2)obtain postfix
        String postfix = infix_to_postfix(reverse);
        //3)Reverse the postfix string
        return new StringBuilder(postfix).reverse().toString();
    }   


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String infix = sc.next();
        sc.close();
        System.out.println("Prefix Expression:"+infix_to_prefix(infix));
    }
}
