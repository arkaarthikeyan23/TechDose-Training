import java.util.*;
public class _0032MergeKsortedLists {
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //TC:O(KlogK)
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null;
        }
        //MinHeap
        Comparator<ListNode> customCompare = new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        };
        PriorityQueue<ListNode> pq = new PriorityQueue<>(customCompare);
        
        for(ListNode list : lists){
            if(list!=null){
                pq.offer(list);
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;
        while(!pq.isEmpty()){
            ListNode lowestNodeVal = pq.poll();
            t.next = lowestNodeVal;
            t = t.next;
            if(lowestNodeVal.next!=null){
                pq.offer(lowestNodeVal.next);
            }
        }
        return dummy.next;
    }
}
