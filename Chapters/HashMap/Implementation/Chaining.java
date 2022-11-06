public class Chaining{
    class MyHashMap {
        class ListNode{
            int key, value;
            ListNode prev, next;
            ListNode(int key, int value){
                this.key = key;
                this.value = value;
            }
        }
        ListNode prepend(ListNode head, int key, int value){
            ListNode nn = new ListNode(key,value);
            nn.next = head;
            if(head!=null) head.prev = nn;
            head = nn;
            return nn;
        }
        ListNode search(ListNode head, int key){
            ListNode temp = head;
            while(temp!=null){
                if(temp.key == key) return temp;
                temp = temp.next;
            }
            return null;
        }
        ListNode delete(ListNode head, ListNode temp){
            ListNode prevNode=temp.prev, nextNode=temp.next;
            if(nextNode != null){
                nextNode.prev = prevNode;
            }
            if(prevNode==null){
                return temp.next;//deleting head
            }
            prevNode.next = nextNode;
            return head;
        }
        ListNode[] arr;
        int size;
        public MyHashMap() {
            size = 769;//larger prime number
            arr = new ListNode[size];
        }
        
        public void put(int key, int value) {
            ListNode prev = search(arr[key%size],key);
            if(prev!=null)  arr[key%size] = delete(arr[key%size],prev);
            arr[key%size] = prepend(arr[key%size],key,value);
        }
        
        public int get(int key) {
            ListNode prev = search(arr[key%size],key);
            return prev==null?-1:prev.value;
        }
        
        public void remove(int key) {
            ListNode prev = search(arr[key%size],key);
            if(prev!=null){
                arr[key%size] = delete(arr[key%size],prev);
            }
        }
    }
    
}