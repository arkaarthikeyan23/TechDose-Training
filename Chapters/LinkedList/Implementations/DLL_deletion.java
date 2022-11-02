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

    void insertAtEnd(int val){
        Node nn = new Node(val);
        if(head==null){
            head = nn;
        }else{
            Node temp = head;
            while(temp.next!=null){
                temp = temp.next;
            }
            nn.prev = temp;
            temp.next = nn;
        }
    }

    void deleteAtbegin(){
        head.next.prev = null;
        head = head.next;
    }

    void deleteAtEnd(){
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.prev.next = null;
    }

    void deleteAtPos(int pos){
        if(pos==1){
            deleteAtbegin();
        }
        else{
            Node temp=head;
            for(int i=0; i<pos-1; i++){
                temp = temp.next;
            }
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
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
public class DLL_deletion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DLL  dll = new DLL();
        int op, n, pos;
        System.out.println("Enter the no. of. elements");
        n = sc.nextInt();
        System.out.println("Enter the elements");
        for(int i=0; i<n; i++){
            dll.insertAtEnd(sc.nextInt());
        }
        dll.display();
        do{
            System.out.println("0)Exit     1)DeleteAtBegin    2)DeleteAtEnd   3)DeleteAtPos");
            op = sc.nextInt();
            switch(op){
                case 1:
                    dll.deleteAtbegin();
                    dll.display();
                    break;
                case 2:
                    dll.deleteAtEnd();
                    dll.display();
                    break;
                case 3:
                    System.out.println("Enter Position");
                    pos=sc.nextInt();
                    dll.deleteAtPos(pos);
                    dll.display();
                    break;
                default:
                    break;
            }
        }while(op!=0);
        sc.close();
    }
}
