/*
110. 平衡二叉树
https://leetcode-cn.com/problems/balanced-binary-tree/
给定一个二叉树，判断它是否是高度平衡的二叉树。
本题中，一棵高度平衡二叉树定义为：
    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
*/

/*
解法：使用-1来表示不是平衡二叉树，从而将boolean和int统一。
执行用时：1 ms, 在所有 Java 提交中击败了99.91% 的用户
内存消耗：38.4 MB, 在所有 Java 提交中击败了95.03% 的用户
*/
class Solution {
    public boolean isBalanced(TreeNode root) {
        return fun(root) != -1;
    }
    public int fun(TreeNode root) {
        if(root == null) return 0;
        int left = fun(root.left);
        if(left == -1) return -1;
        int right = fun(root.right);
        if(right == -1 || Math.abs(left - right) > 1) return -1;
        return 1 + Math.max(right, left);
    }
}

