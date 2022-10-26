package Assignments;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}

public class reverse_Recursive {
    static Node head;
    static void reverse(Node prev, Node curr){
        //Termination condition for no nodes in LL
        if(curr==null){
            return;
        }  
        //Termination condition for  end nodes in LL    
        if(curr.next == null){
            head = curr;
            curr.next = prev;
            return;
        }
        reverse(curr,curr.next);
        curr.next = prev;

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
        reverse(null,head);
        display(head);   
    }
}
