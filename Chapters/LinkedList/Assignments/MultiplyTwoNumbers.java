package Assignments;

public class MultiplyTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static int multiplyTwoLists(ListNode l1, ListNode l2){
        int num1=0, num2=0;
        while(l1!=null || l2!=null){
            if(l1!=null){
                num1 = (num1*10) + l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                num2 = (num2*10) + l2.val;
                l2 = l2.next;
            }

        }
        return (num1*num2);
    }

    public static void main(String[] args) {
        //First List
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(5);
        //Second List
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(5);
        //Result
        //15 * 15
        System.out.println(multiplyTwoLists(l1,l2));
    }
}
