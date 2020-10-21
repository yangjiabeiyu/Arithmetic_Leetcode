/*
剑指 Offer 68 - I. 二叉搜索树的最近公共祖先

给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]

示例 1:

输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6 
解释: 节点 2 和节点 8 的最近公共祖先是 6。
*/

/*
解法一：递归
执行用时：6 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：39 MB, 在所有 Java 提交中击败了99.02% 的用户
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return root;
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        if(root.val < q.val && root.val < p.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}

/*
解法二：迭代
执行用时：6 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：39.5 MB, 在所有 Java 提交中击败了95.63% 的用户
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            if(root.val > p.val && root.val > q.val)
                root = root.left;
            else if(root.val < p.val && root.val < q.val)
                root = root.right;
            else
                break;
        }
        return root;
    }
}

