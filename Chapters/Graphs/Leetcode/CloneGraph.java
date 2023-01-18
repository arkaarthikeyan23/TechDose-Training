import java.util.*;

//TC:O(V+E)
public class CloneGraph{
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node) {
        if(node==null)  return null;
    
        //(Original Graph, New Graph)
        Map<Node,Node> map = new HashMap<>(); 
        Queue<Node> q = new LinkedList<>(); 
    
        Node newNode = new Node();
        newNode.val = node.val;
        map.put(node, newNode);
        q.offer(node);
    
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node child : curr.neighbors){
                if(!map.containsKey(child)){
                    Node newChild = new Node();
                    newChild.val = child.val;
                    map.put(child, newChild);
                    q.offer(child);
                }
                Node newListNode = map.get(curr);
                newListNode.neighbors.add(map.get(child));
            }
        }
        return map.get(node);
    }
    
}