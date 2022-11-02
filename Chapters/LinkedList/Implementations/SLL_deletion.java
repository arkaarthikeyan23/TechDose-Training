package Implementations;
import java.util.Scanner;
class SLL{
    static Node head=null;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }

    void insertAtEnd(int val){
        Node nn = new Node(val);
        if(head==null){
            head = nn;
        }else{
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next = nn;
        }
    }

    void deleteAtbegin(){
        head = head.next;
    }

    void deleteAtEnd(){
        Node temp = head;
        while(temp.next!=null && temp.next.next!=null){
            temp = temp.next;
        }
        temp.next = null;
    }

    void deleteAtPos(int pos){
        if(pos==1){
            deleteAtbegin();
        }
        else{
            Node temp=head, prev=null;
            for(int i=1; i<pos; i++){
                prev = temp;
                temp = temp.next;
            }
            prev.next = temp.next;
        }
    }

    void display(){
        System.out.println("The elements in the SLL are");
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }
}
public class SLL_deletion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLL  sll = new SLL();
        int op, n, pos;
        System.out.println("Enter the no. of. elements");
        n = sc.nextInt();
        System.out.println("Enter the elements");
        for(int i=0; i<n; i++){
            sll.insertAtEnd(sc.nextInt());
        }
        sll.display();
        do{
            System.out.println("0)Exit     1)DeleteAtBegin    2)DeleteAtEnd   3)DeleteAtPos");
            op = sc.nextInt();
            switch(op){
                case 1:
                    sll.deleteAtbegin();
                    sll.display();
                    break;
                case 2:
                    sll.deleteAtEnd();
                    sll.display();
                    break;
                case 3:
                    System.out.println("Enter Position");
                    pos=sc.nextInt();
                    sll.deleteAtPos(pos);
                    sll.display();
                    break;
                default:
                    break;
            }
        }while(op!=0);
        sc.close();
    }
}


