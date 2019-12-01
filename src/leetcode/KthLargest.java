package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : KthLargest
 * Creator : Robina
 * Date : Nov, 2019
 * Description : 703. Kth Largest Element in a Stream
 */
 class KthLargest {
    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            pq.add(num);
        }
        while(pq.size() > k) {
            pq.remove();
        }
    }
    
    public int add(int val) {
        if(pq.size() < k)
            pq.add(val);
        else if (pq.peek() < val) {
            pq.remove();
            pq.add(val);
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
