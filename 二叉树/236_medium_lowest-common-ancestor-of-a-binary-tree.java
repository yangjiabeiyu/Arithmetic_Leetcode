/*
二叉树的最近公共祖先
https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

示例
输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1    输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
*/

/*
解法：最基本的思路是对于当前节点，指定节点位于哪个位置，如果分别位于左右子树，那么就应该返回当前节点；如果都在左子树，那么就向左子树下移。
执行用时：2570 ms, 在所有 Java 提交中击败了5.04% 的用户
内存消耗：39.8 MB, 在所有 Java 提交中击败了98.46% 的用户
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q)
            return root;
        if(isChild(root.left, p) && isChild(root.left, q))             // 如果都在左子树，那么就继续左找
            return lowestCommonAncestor(root.left, p, q);
        if(isChild(root.right, p) && isChild(root.right, q))           // 如果都在右子树，那么就继续右找
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
    public boolean isChild(TreeNode root, TreeNode p) {                // 判断是不是当前节点的子代
        if(root == null)
            return false;
        if(root == p)
            return true;
        return isChild(root.left, p) || isChild(root.right, p);
    }
}


/*
解法二：上述解法明显复杂度很高，每次都要判断p和q位于哪个位置，重复计算很多。其实原函数也是要返回值的，因此可以通过返回的值来判断是否在子树中
执行用时：8 ms, 在所有 Java 提交中击败了61.89% 的用户
内存消耗：40.3 MB, 在所有 Java 提交中击败了96.51% 的用户
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)                  // 如果遇到了节点，或者没找到，那么就返回节点
            return root;
        TreeNode nodeL = lowestCommonAncestor(root.left, p, q);     // 向左找
        TreeNode nodeR = lowestCommonAncestor(root.right, p, q);    // 向右找
        if(nodeL == null)                                           // 如果左侧没有，那么必然是nodeR
            return nodeR;
        if(nodeR == null)                                           // 如果右侧没有，那么必然是nodeL
            return nodeL;
        return root;                                                // 如果两侧都有，那么就返回root
    }
}

