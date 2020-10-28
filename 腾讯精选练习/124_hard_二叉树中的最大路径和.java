/*
124. 二叉树中的最大路径和

给定一个非空二叉树，返回其最大路径和。
本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

示例 1：
输入：[1,2,3]

       1
      / \
     2   3

输出：6

示例 2：
输入：[-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

输出：42
*/

/*
解法：递归
执行用时：1 ms, 在所有 Java 提交中击败了99.78% 的用户
内存消耗：40.3 MB, 在所有 Java 提交中击败了91.18% 的用户
*/
class Solution {
    public int res = Integer.MIN_VALUE;      // 记录最大值
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return res;
    }
    public int maxPath(TreeNode root) {
        if(root == null)
            return 0;
        int left = Math.max(maxPath(root.left), 0), right = Math.max(maxPath(root.right), 0);   // 得到左右子树的最大值，如果小于0，那么就不用它
        res = Math.max(res, root.val + left + right);   // 更新结果
        return root.val + Math.max(left, right);     // 返回自己和左子树或右子树，谁大返回谁
    }
}

