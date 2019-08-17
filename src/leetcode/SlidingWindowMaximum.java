package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : SlidingWindowMaximum
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 239. Sliding Window Maximum
 */
public class SlidingWindowMaximum {
    /**
     * For example,
     Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.

     Window position                Max
     ---------------               -----
     [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7
     Therefore, return the max sliding window as [3,3,5,5,6,7].

     Deque : 存的是index 从大到小排序

     time : O(n)
     space : O(n)

     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return new int[0];
        }
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[nums.length + 1 - k];
        for(int i = 0; i < nums.length; i++) {
            if(!list.isEmpty() && list.peekFirst() == i - k) {
                list.poll();
            }
            // Remove all element that is less than nums[i]
            while(!list.isEmpty() && nums[list.peekLast()] < nums[i]) {
                list.removeLast();
            }
            // Save the index to end
            list.offerLast(i);
            if((i + 1) >= k) {
                res[i + 1 - k] = nums[list.peek()];
            }
        }
        return res;
    }
}
