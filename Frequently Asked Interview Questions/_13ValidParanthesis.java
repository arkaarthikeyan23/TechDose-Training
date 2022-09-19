import java.util.*;
public class _13ValidParanthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty())
                    return false;
                if(!(stack.peek()=='(' && ch==')' || stack.peek()=='[' && ch==']' || stack.peek()=='{' && ch=='}' ))
                    return false;
                else
                    stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
