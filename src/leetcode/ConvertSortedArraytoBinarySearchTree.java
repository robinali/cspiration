package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ConvertSortedArraytoBinarySearchTree
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class ConvertSortedArraytoBinarySearchTree {
    /**
     * 108. Convert Sorted Array to Binary Search Tree

     [1,2,3,4,5]

     time : O(n);
     space : O(n);
     * @param nums
     * @return
     */
    // 108
    // Reference: leetcode caikehe
    // https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/discuss/35356/Java-dfs-solution.
    // Time O(n) Space: O(n)
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return sortedArrayToBST( nums, 0, nums.length );
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int start, int len) {
        if(len == 0) return null;
        int half = len / 2;
        TreeNode node = new TreeNode( nums[start + half] );
        node.left = sortedArrayToBST(nums, start, half);
        node.right = sortedArrayToBST(nums, start + half + 1, len - half - 1);
        return node;
    }
}
