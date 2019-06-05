package leetcode;

import java.util.*;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : CloneGraph
 * Creator : Edward
 * Date : Oct, 2017
 * Description : 133. Clone Graph
 */
public class CloneGraph {
    /**
     * time : O(m + n) m : nodes n : edges
     * space : O(m)
     */

    Map<Node, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        return cloneGraphRec(node);
    }
    
    private Node cloneGraphRec(Node node) {
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);
        List<Node> neighbors = new ArrayList<>();
        Node clone = new Node(node.val, neighbors);
        map.put(node, clone);
        for(Node neighbor: node.neighbors) {
            neighbors.add(cloneGraphRec(neighbor));
        }
        return clone;
    }

    public Node cloneGraph2(Node node) {
        if(node == null) return node;
        List<Node> nodes = getNodes(node);
        HashMap<Node, Node> map = new HashMap<>();
        
        for(Node cur : nodes) {
            List<Node> neighbors = new ArrayList<>();
            map.put(cur, new Node(cur.val, neighbors));
        }
        for(Node cur: nodes) {
            Node newNode = map.get(cur);
            for(Node neighbor : cur.neighbors) {
                newNode.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
    
    private List<Node> getNodes(Node node) {
        Queue<Node> queue = new LinkedList<>();
        HashSet<Node> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            for(Node neighbor : cur.neighbors) {
                if(!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
