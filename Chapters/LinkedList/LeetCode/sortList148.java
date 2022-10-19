package LeetCode;

public class sortList148 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //TC:O(NlogN)
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        //Find Middle
        ListNode slow=head, fast=head, prev=null;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next;
            if(fast!=null){
                fast = fast.next;
            }
        }
        prev.next = null;
        //Merge Sort
        ListNode first = sortList(head);
        ListNode second = sortList(slow);
        return merge(first,second);
    }
    public ListNode merge(ListNode head1, ListNode head2){
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(head1!=null && head2!=null){
            if(head1.val < head2.val){
                temp.next = head1;
                head1 = head1.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        while(head1!=null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2!=null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return dummy.next;
    }   
}