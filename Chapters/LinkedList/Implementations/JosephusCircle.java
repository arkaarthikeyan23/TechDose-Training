package Implementations;
import java.util.Scanner;

public class JosephusCircle {
    static class Node{
        private int data;
        private Node next;
        Node(int data){
            this.data = data;
        }
    }

    static int getJosephusPosition(int n, int k){
        Node head = new Node(1);
        Node prev = head;
        for(int i=2; i<=n; i++){
            prev.next = new Node(i);
            prev = prev.next;
        }
        prev.next = head;

        Node ptr1=head, ptr2=head;

        while(ptr1.next != ptr1){
            int count=1;
            while(count!=k){
                ptr2 = ptr1;
                ptr1 = ptr1.next;
                count++;
            }
            ptr2.next = ptr1.next;
            ptr1 = ptr2.next;
        }
        return ptr1.data;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();
        System.out.println(getJosephusPosition(n,k));
    }
}
