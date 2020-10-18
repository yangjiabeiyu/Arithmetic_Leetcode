/*
验证二叉搜索树
https://leetcode-cn.com/problems/validate-binary-search-tree/
给定一个二叉树，判断其是否是一个有效的二叉搜索树。
假设一个二叉搜索树具有如下特征：
    节点的左子树只包含小于当前节点的数。
    节点的右子树只包含大于当前节点的数。
    所有左子树和右子树自身必须也是二叉搜索树。
示例
输入:
    2
   / \
  1   3
输出: true
*/

/*
解法一：迭代，中序遍历或者后序遍历都可，主要在设置初始的最大值或者最小值时需要用Long或者Double的最大最小值
执行用时：1 ms, 在所有 Java 提交中击败了36.20% 的用户
内存消耗：37.6 MB, 在所有 Java 提交中击败了100.00% 的用户
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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double curMax = Double.MAX_VALUE;
        while(root != null || !stack.isEmpty()) {        // 后序遍历
            while(root != null) {
                stack.add(root);
                root = root.right;
            }
            root = stack.pop();
            if(root.val >= curMax)
                return false;
            curMax = root.val;
            root = root.left;
        }
        return true;
    }
}

/*
解法二：递归，使用成员变量记录最大值
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：37.6 MB, 在所有 Java 提交中击败了100.00% 的用户
*/
class Solution {
    double curMax = Double.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        if(!isValidBST(root.right) || root.val >= curMax)
            return false;
        curMax = root.val;
        return isValidBST(root.left);
    }
}

