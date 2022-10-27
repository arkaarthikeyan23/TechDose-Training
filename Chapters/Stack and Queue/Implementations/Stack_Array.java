import java.util.Scanner;

class Stack{
    int capacity, size, top;
    int[] arr;
    Stack(int capacity){
        this.capacity = capacity;
        top = -1;
        size=0;
        arr = new int[capacity];
    }
    boolean isEmpty(){
        return size==0;
    }
    boolean isFull(){
        return size==capacity;
    }
    void push(int val){
        if(isFull()){
            System.out.println("Stack is Full");
            return;
        }
        arr[++top] = val;
        size++; 
    }
    int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        size--;
        return arr[top--];
    }
    int peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        return arr[top];
    }
}

class Stack_Array{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the capacity of the Stack");
        int capacity = sc.nextInt();
        Stack stk = new Stack(capacity);
        
        while(true){
            System.out.println("Operations: \n1)Push \n2)Pop \n3)Peek \n4)Exit");
            int option = sc.nextInt();
            boolean exit = false;
            switch(option){
                case 1:
                    System.out.println("Enter the element to be pushed\n");
                    int val = sc.nextInt();
                    stk.push(val);
                    break;
                case 2:
                    System.out.println("Popped element : "+stk.pop());
                    break;
                case 3:
                    System.out.println("Peek element : "+stk.peek());
                    break;
                default:
                    exit = true;
                    break;
            }
            if(exit){
                break;
            }
        }
        sc.close();
    }
}