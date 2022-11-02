public class FlattenAMultiLevelDLL430{
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    public Node flatten(Node head) {
        if(head==null){
            return head;
        }
        Node it = head;
        while(it!=null){
            //if child node exists
            if(it.child!=null){
                Node next = it.next;//store the reference of next node at curr level
                it.next = flatten(it.child);//flatten the child node
                it.next.prev = it;
                it.child = null; // make curr node child null
                
                //Traverse till last node of the next level
                while(it.next!=null){
                    it = it.next;
                }
                //Make the terminal node point to the reference stored in 1st level
                if(next!=null){
                    it.next = next;
                    it.next.prev = it;
                }
            }
            it = it.next;
        }
        
        return head;
    }
}