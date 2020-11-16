/*
111. 二叉树的最小深度
https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
给定一个二叉树，找出其最小深度。
最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
说明：叶子节点是指没有子节点的节点。
*/

/*
解法：见注释
执行用时：10 ms, 在所有 Java 提交中击败了6.39% 的用户
内存消耗：59.1 MB, 在所有 Java 提交中击败了8.39% 的用户
*/
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null || root.right == null)
            return 1 + Math.max(minDepth(root.left), minDepth(root.right)); //  如果左右子树有null，就返回较大值
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));  // 都不为空，就返回较小值
    }
}


