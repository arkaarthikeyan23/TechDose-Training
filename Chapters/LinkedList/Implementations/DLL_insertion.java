package Implementations;
import java.util.Scanner;
class DLL{
    static Node head=null;
    class Node{
        int data;
        Node next, prev;
        Node(int data){
            this.data = data;
            next = null;
            prev = null;
        }
    }

    void insertAtbegin(int val){
        Node nn = new Node(val);
        if(head==null){
            head = nn;
        }else{
            nn.next = head;
            head.prev = nn;
            head = nn;
        }
    }

    void insertAtEnd(int val){
        Node nn = new Node(val);
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        nn.prev = temp;
        temp.next = nn;
    }

    void insertAtPos(int pos, int val){
        if(pos==1){
            insertAtbegin(val);
        }
        else{
            Node temp = head;
            Node nn = new Node(val);
            for(int i=1; i<pos-1; i++){
                temp = temp.next;
            }
            nn.prev = temp;
            nn.next = temp.next;
            temp.next = nn;
        }
    }

    void display(){
        System.out.println("The elements in the DLL are");
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }
}
public class DLL_insertion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLL  dll = new DLL();
        int op, n, pos;
        do{
            System.out.println("0)Exit     1)InsertAtBegin    2)InsertAtEnd   3)InsertAtPos");
            op = sc.nextInt();
            switch(op){
                case 1:
                    System.out.println("Enter data");
                    n=sc.nextInt();
                    dll.insertAtbegin(n);
                    dll.display();
                    break;
                case 2:
                    System.out.println("Enter data");
                    n=sc.nextInt();
                    dll.insertAtEnd(n);
                    dll.display();
                    break;
                case 3:
                    System.out.println("Enter data");
                    n=sc.nextInt();
                    System.out.println("Enter Position");
                    pos=sc.nextInt();
                    dll.insertAtPos(pos,n);
                    dll.display();
                    break;
                default:
                    break;
            }
        }while(op!=0);
        sc.close();
    }
}

