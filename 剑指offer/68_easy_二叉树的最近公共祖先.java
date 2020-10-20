/*
剑指 Offer 68 - II. 二叉树的最近公共祖先

给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。百度百科中最近公共祖先的定义为：
“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

示例 1:
输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
*/

/*
解法：递归
执行用时：8 ms, 在所有 Java 提交中击败了57.69% 的用户
内存消耗：39.6 MB, 在所有 Java 提交中击败了98.29% 的用户
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        TreeNode childL = lowestCommonAncestor(root.left, p, q);
        TreeNode childR = lowestCommonAncestor(root.right, p, q);
        if(childL != null && childR != null)         // 说明左边也有，右边也有，这时返回root
            return root;
        return childL == null ? childR : childL;
    }
}


