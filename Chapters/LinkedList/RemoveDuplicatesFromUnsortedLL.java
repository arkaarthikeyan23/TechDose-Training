import java.util.HashSet;

public class RemoveDuplicatesFromUnsortedLL {
    static Node head;
    public static class Node{
        private int data;
        private Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    public static void removeDuplicates(){
        HashSet<Integer> set = new HashSet<>();
        Node curr = head, prev = null;
        while(curr!=null){
            if(set.contains(curr.data)){
                prev.next = curr.next;
            }else{
                set.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
    }

    public static void display(){
        Node temp = head;
        System.out.println("The elements in linked list are: ");
        while(temp!=null){
            System.out.print(temp.data+"->");
        }
        System.out.print("NULL");
    }
    public static void main(String[] args) {
        Node ll = new Node(11);
        ll.next = new Node(18);
        ll.next.next = new Node(11);
        ll.next.next.next = new Node(15);
        ll.next.next.next.next = new Node(18);
        display();
        removeDuplicates();
        display();
    }
    
}
