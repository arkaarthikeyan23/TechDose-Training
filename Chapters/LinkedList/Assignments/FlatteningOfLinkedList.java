package Assignments;

public class FlatteningOfLinkedList {
    class Node
    {
        int data;
        Node next;
        Node bottom;
        
        Node(int d)
        {
            data = d;
            next = null;
            bottom = null;
        }
    }
    public Node merge(Node a, Node b){
        Node temp = new Node(0);
        Node res = temp;
        
        while(a!=null && b!=null){
            if(a.data <= b.data){
                temp.bottom = a;
                a = a.bottom;
            }else{
                temp.bottom = b;
                b = b.bottom;
            }
            temp = temp.bottom;
        }
        if(a!=null) temp.bottom = a;
        else temp.bottom = b;
        return res.bottom;
    }
    
    public Node flatten(Node head) {
        if(head == null || head.next==null){
            return head;
        }
        //recur for list on right
        head.next = flatten(head.next);
        //merge
        head.next = merge(head,head.next);
        //return the head it will merge with its left
        return head;
    }
}
