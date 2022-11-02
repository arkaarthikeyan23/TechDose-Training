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

    void deleteAtbegin(){
        Node temp = head;
        while(temp.next != head){
            temp = temp.next;
        }
        temp.next  = head.next;
        head = head.next;
    }

    void deleteAtEnd(){
        Node temp = head, prev=null;
        while(temp.next!=head){
            prev = temp;
            temp = temp.next;
        }
        prev.next = head;
    }

    void deleteAtPos(int pos){
        if(pos==1){
            deleteAtbegin();
        }else{
            Node temp = head, prev=null;
            for(int i=1; i<pos; i++){
                prev = temp;
                temp = temp.next;
            }
            prev.next = temp.next;
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
public class CLL_deletion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CLL  cll = new CLL();
        int op, n, pos;
        System.out.println("Enter the no. of. elements");
        n = sc.nextInt();
        System.out.println("Enter the elements");
        for(int i=0; i<n; i++){
            cll.insertAtbegin(sc.nextInt());
        }
        cll.display();
        do{
            System.out.println("0)Exit     1)DeleteAtBegin    2)DeleteAtEnd   3)DeleteAtPos");
            op = sc.nextInt();
            switch(op){
                case 1:
                    cll.deleteAtbegin();
                    cll.display();
                    break;
                case 2:
                    cll.deleteAtEnd();
                    cll.display();
                    break;
                case 3:
                    System.out.println("Enter Position");
                    pos=sc.nextInt();
                    cll.deleteAtPos(pos);
                    cll.display();
                    break;
                default:
                    break;
            }
        }while(op!=0);
        sc.close();
    }
}


