/*
二叉树的直径
https://leetcode-cn.com/problems/diameter-of-binary-tree/
题目描述
给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
示例
给定二叉树

          1
         / \
        2   3
       / \     
      4   5    

返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
*/

/*
解法一：最大路径可能穿过根节点，也可能不穿过。
两个递归，一个递归得到树的最大深度；另一个递归比较左子树的直径、右子树的直径、左右子树深度和，取最大返回。
该方法复杂度高，因为每到一个节点，都要调用递归计算左右子树的直径
执行用时：12 ms, 在所有 Java 提交中击败了10.42% 的用户
内存消耗：39.1 MB, 在所有 Java 提交中击败了5.68% 的用户
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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        int k = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));
        return Math.max(depthOfTree(root.left) + depthOfTree(root.right), k);
    }
    public static int depthOfTree(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(depthOfTree(root.left), depthOfTree(root.right));
    }
}

/*
解法二：定义一个类内变量，maxNum，在计算深度的时候，刷新最大值
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.7 MB, 在所有 Java 提交中击败了76.13% 的用户
*/
class Solution {
    int maxNum = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depthOfTree(root);
        return maxNum;
    }
    public int depthOfTree(TreeNode root) {
        if(root == null)
            return 0;
        int num1 = depthOfTree(root.left), num2 = depthOfTree(root.right);
        maxNum = Math.max(num1 + num2, maxNum);  // 左右子树的加和
        return Math.max(num1, num2) + 1;  // 返回深度
    }
}
