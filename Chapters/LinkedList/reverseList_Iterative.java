package TechDose_Training.Chapters.LinkedList;
import java.util.Scanner;
public class reverseList_Iterative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        //Creating Linked list
        ListNode head = ListNode.convertArrToList(arr);
        head = reverse(head);
        ListNode.display(head);

    }
    public static ListNode reverse(ListNode head){
        ListNode newHead = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
    public static  class ListNode {
        public int val;
        public ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val = val;
        }
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
        public static  void display(ListNode head){
            ListNode temp = head;
            while(temp!=null){
                System.out.print(temp.val+"->");
                temp = temp.next;
            }
            System.out.print("NULL");
        }
        public  int size(ListNode head){
            ListNode temp = head;
            int count=0;
            while(temp!=null){
                count++;
                temp = temp.next;
            }
            return count;
        }
        public static  ListNode convertArrToList(int[] arr){
            ListNode ptr = new ListNode();
            ListNode temp = ptr;
            for(int val : arr){
                temp.next = new ListNode(val);
                temp =temp.next;
            }
            return ptr.next;
        }
    }
    
}
