package Assignments;
public class LinkedListOperations
{
    static Node head;
    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    //Insertion
    public static void prepend(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
    }

    public static void append(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        } 
        else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public static void insertAtPos(int data, int pos){
        Node newNode = new Node(data);
        if(pos == 1){
            newNode.next = head;
            head = newNode;
        }
        else{
            int count=1;
            Node temp = head;
            while(count < pos-1 &&  temp.next!=null){
                temp = temp.next;
                count++;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }
    //Deletion
    public static void deleteAtBegining(){
        if(head != null){
            head = head.next;
        }else{
            System.out.println("List is Empty!!!");
        }
    }

    public static void deleteAtEnd(){
        if(head == null){
            System.out.println("List is Empty!!!");
        }else if(head.next == null){
            head = null;
        }else{
            Node temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    public static void deleteAtPos(int pos){
        if(pos == 1){
            head = head.next;
        }
        else{
            Node temp = head;
            int count = 1;
            while(count < pos-1 && temp != null){
                temp = temp.next;
                count++;
            }
            temp.next = temp.next.next;
        }
    }

    //Reverse Iterative: TC:O(N) SC:O(1)
    public static Node reverse_Iterative(){
        Node newHead = null;
        while(head != null){
            Node next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    //Reverse Recursive: TC:O(N) SC:O(N)
    public static void reverse_Recursive(Node prev, Node curr){
        //If linkedlist is empty
        if(head==null){
            return;
        }
        //If last node, then make it as head
        if(curr.next==null){
            head=curr;
            curr.next = prev;
            return;
        }
        reverse_Recursive(curr, curr.next);
        curr.next = prev;
    }

    //Display
    public static void display()
    {
        Node temp = head;
        System.out.println("The elements in the linked list are");
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("NULL\n");
    }


    public static void main(String[] args) {
        append(10);
        append(20);
        append(30);
        append(40);
        append(50);
        display();
        //display(reverse_Iterative());
        reverse_Recursive(null,head);
        display();
    }
}