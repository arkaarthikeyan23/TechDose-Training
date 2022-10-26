package Assignments;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}

public class reverse_Iterative {
    static Node head;
    static void reverse(){
        Node newHead = null, curr = head;
        while(curr!=null){
            Node next = curr.next;
            curr.next = newHead;
            newHead = curr;
            curr = next;
        }
        head = newHead;
    }

    static void display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("NULL");
        System.out.println();
    }
    public static void main(String[] args) {
        head  = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        display(head);
        reverse();
        display(head);   
    }
}
