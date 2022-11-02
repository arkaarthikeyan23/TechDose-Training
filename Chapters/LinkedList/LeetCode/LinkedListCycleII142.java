
//Find the starting point of a cycle
public class LinkedListCycleII142 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //TC:O(N) SC:O(1)
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode slow=head, fast=head, entry=head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                while(slow != entry){
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
    }
}
