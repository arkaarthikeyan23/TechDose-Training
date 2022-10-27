import java.util.Scanner;

class Queue{
    int front, rear, size, capacity;
    int[] arr;
    Queue(int capacity){
        this.capacity = capacity;
        front=0; size=0;
        rear = -1;
        arr = new int[capacity];
    }
    boolean isFull(){
        return size==capacity;
    }
    boolean isEmpty(){
        return size==0;
    }
    void enqueue(int val){
        if(isFull()){
            System.out.println("Queue is Full");
            return;
        }
        size++;
        arr[++rear%capacity] =val;
    }
    int dequeue(){
        if(isEmpty()){
            System.err.println("Queue is Empty");
            return -1;
        }
        size--;
        return arr[front++%capacity];
    }
    int front(){
        if(isEmpty()){
            System.err.println("Queue is Empty");
            return -1;
        }
        return arr[front];
    }
    int rear(){
        if(isEmpty()){
            System.err.println("Queue is Empty");
            return -1;
        }
        return arr[rear];
    }
    void display(){
        for(int i=front; i<=rear; i++){
            System.out.print(arr[i]+" ");
        }
    }
}


public class Queue_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the capacity of the Queue");
        int capacity = sc.nextInt();
        boolean exit = false;
        Queue q = new Queue(capacity);
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
