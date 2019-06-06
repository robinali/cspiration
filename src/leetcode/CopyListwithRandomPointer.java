package leetcode;

import java.util.HashMap;
import java.util.Random;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : CopyListwithRandomPointer
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}
public class CopyListwithRandomPointer {
    /**
     * 138. Copy List with Random Pointer
     * A linked list is given such that each node contains an additional random pointer which could
     * point to any node in the list or null.

     Return a deep copy of the list

     time : O(n);
     space : O(n);
     * @param head
     * @return
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = head;
        while (cur != null) {
            map.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**

     1->1'->2->2'->3->3'->4->4'

     1'->2'->3'->4'
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head) {
        // Time: O(n) Space: O(1)
        Node cur = head;
        
        //next copy
        while(cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }
        
        cur = head;
        //random copy
        while(cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        
        cur = head;
        Node next = head.next;
        Node rtn = head.next;
        while (cur != null) {
        cur.next = cur.next.next;
        if (next.next != null) {
            next.next = next.next.next;
        }
        cur = cur.next;
        next = next.next;
        }
        return rtn;
    }
}
