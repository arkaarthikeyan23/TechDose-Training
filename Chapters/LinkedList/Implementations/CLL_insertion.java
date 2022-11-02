package Implementations;
import java.util.Scanner;
class CLL{
    static Node head=null;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    void insertAtbegin(int val){
        Node nn = new Node(val);
        if(head==null){
            head = nn;
            head.next = head;
        }else{
            Node temp = head;
            while(temp.next!=head){
                temp = temp.next;
            }
            nn.next = head;
            temp.next = nn;
            head = nn;
        }
    }

    void insertAtEnd(int val){
        Node nn = new Node(val);
        Node temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        temp.next = nn;
        nn.next = head;
    }

    void insertAtPos(int pos, int val){
        if(pos==1){
            insertAtbegin(val);
        }else{
            Node nn = new Node(val);
            Node temp =  head;
            for(int i=1; i<pos-1; i++){
                temp = temp.next;
            }
            nn.next = temp.next;
            temp.next = nn;
        }
    }

    void display(){
        System.out.println("The elements in the CLL are");
        Node temp = head;

        while(temp.next != head){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print(temp.data+"->");
        System.out.print("NULL");
        System.out.println();
    }
}
public class CLL_insertion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CLL  cll = new CLL();
        int op, n, pos;
        do{
            System.out.println("0)Exit     1)InsertAtBegin    2)InsertAtEnd   3)InsertAtPos");
            op = sc.nextInt();
            switch(op){
                case 1:
                    System.out.println("Enter data");
                    n=sc.nextInt();
                    cll.insertAtbegin(n);
                    cll.display();
                    break;
                case 2:
                    System.out.println("Enter data");
                    n=sc.nextInt();
                    cll.insertAtEnd(n);
                    cll.display();
                    break;
                case 3:
                    System.out.println("Enter data");
                    n=sc.nextInt();
                    System.out.println("Enter Position");
                    pos=sc.nextInt();
                    cll.insertAtPos(pos,n);
                    cll.display();
                    break;
                default:
                    break;
            }
        }while(op!=0);
        sc.close();
    }
}

