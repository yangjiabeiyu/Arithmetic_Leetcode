/*
对称二叉树
https://leetcode-cn.com/problems/symmetric-tree/
题目描述
给定一个二叉树，检查它是否是镜像对称的。
例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    1
   / \
  2   2
 / \ / \
3  4 4  3
*/

/*
解法：递归
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：36.7 MB, 在所有 Java 提交中击败了98.54% 的用户
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return fun(root.left, root.right);
    }
    public static boolean fun(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        if(root1 != null && root2 != null)
            return root1.val == root2.val && fun(root1.left, root2.right) && fun(root1.right, root2.left);
        return false;
    }
}
