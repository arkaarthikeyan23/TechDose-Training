public class ReverseNodesInKgroups25 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //TC : O((N/k) * (k)) ==> O(N) ; SC:O(1)
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k==1){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, cur = dummy, nex = dummy;
        int count=0;
        while(cur.next != null){
            count++;
            cur = cur.next;
        }
        while(count>=k){
            cur = pre.next;
            nex = cur.next;
            //Reverse k-1 links
            for(int i=1; i<k; i++){
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;//Updating the curr element
                nex = cur.next;                
            }
            count -= k;
            pre = cur;
        }
        return dummy.next;
    }
}
