/*
669. 修剪二叉搜索树
https://leetcode-cn.com/problems/trim-a-binary-search-tree/
给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。
修剪树不应该改变保留在树中的元素的相对结构（即，如果没有被移除，原有的父代子代关系都应当保留）。 可以证明，存在唯一的答案。
所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
*/

/*
解法：递归
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38 MB, 在所有 Java 提交中击败了90.87% 的用户
*/
class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
       if(root == null) return null;
       if(root.val < low) return trimBST(root.right, low, high);   // 返回处理后的右孩子
       if(root.val > high) return trimBST(root.left, low, high);   // 返回处理后的左孩子
       root.left = trimBST(root.left, low, high);                  // 处理左右孩子后，返回该节点
       root.right = trimBST(root.right, low, high);
       return root;
    }
}

