/*
二叉树的中序遍历
https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]

进阶: 递归算法很简单，你可以通过迭代算法完成吗？
*/

/*
解法一：递归
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：36.5 MB, 在所有 Java 提交中击败了99.42% 的用户
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        fun(root, list);
        return list;
    }
    public void fun(TreeNode node, List list) {
        if(node == null)
            return;
        fun(node.left, list);
        list.add(node.val);
        fun(node.right, list);
    }
}

/*
解法二：迭代，参照递归的过程来写迭代代码
执行用时：1 ms, 在所有 Java 提交中击败了45.99% 的用户
内存消耗：36.4 MB, 在所有 Java 提交中击败了99.74% 的用户
*/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}
