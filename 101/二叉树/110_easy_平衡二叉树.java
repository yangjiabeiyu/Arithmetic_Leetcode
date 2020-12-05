/*
110. 平衡二叉树
https://leetcode-cn.com/problems/balanced-binary-tree/
给定一个二叉树，判断它是否是高度平衡的二叉树。
*/

/*
执行用时：1 ms, 在所有 Java 提交中击败了99.80% 的用户
内存消耗：38.6 MB, 在所有 Java 提交中击败了68.67% 的用户
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return func(root) != -1;
    }
    public int func(TreeNode root) {
        if(root == null) return 0;
        int leftNum = func(root.left);
        if(leftNum == -1) return -1;
        int rightNum = func(root.right);
        if(rightNum == -1 || Math.abs(leftNum - rightNum) > 1) return -1;
        return 1 + Math.max(leftNum, rightNum);
    }
}

