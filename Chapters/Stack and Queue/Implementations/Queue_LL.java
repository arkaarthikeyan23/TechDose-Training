import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
class Queue{
    Node front, rear;
    Queue(){
        front = rear = null;
    }
    boolean isEmpty(){
        return front==null;
    }
    void enqueue(int val){
        Node nn = new Node(val);
        if(isEmpty()){
            front = rear = nn;
            return;
        }
        rear.next = nn;
        rear = nn;
    }
    int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        int res = front.data;
        front  = front.next;
        return res;
    }
    int front(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return front.data;
    }
    int rear(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return -1;
        }
        return rear.data;
    }
    void display(){
        Node temp = front;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }
}

public class Queue_LL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        Queue q = new Queue();
        while(true){
            System.out.println("Enter the option \n1)Enqueue \n2)Dequeue \n3)Front \n4)Rear \n5)Display \n6)Exit");
            int option = sc.nextInt();
            switch(option){
                case 1:
                    System.out.println("Enter the element to insert");
                    int val = sc.nextInt();
                    q.enqueue(val);
                    break;
                case 2:
                    System.out.println("Dequeued element : "+q.dequeue());
                    break;
                case 3:
                    System.out.println("Front element : "+q.front());
                    break;
                case 4:
                    System.out.println("Rear element : "+q.rear());
                    break;
                case 5:
                    System.out.println("The elements in the queue : ");
                    q.display();
                    break;
                default:
                    exit=true;
                    break;
            }
            if(exit){
                break;
            }
        }
        sc.close();
    }    
}
