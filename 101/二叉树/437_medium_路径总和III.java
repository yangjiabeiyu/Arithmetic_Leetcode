/*
437. 路径总和 III
https://leetcode-cn.com/problems/path-sum-iii/
给定一个二叉树，它的每个结点都存放着一个整数值。
找出路径和等于给定数值的路径总数。
路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。

示例：
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

返回 3。和等于 8 的路径有:

1.  5 -> 3
2.  5 -> 2 -> 1
3.  -3 -> 11
*/

/*
解法：双重dfs，第一重设置开始节点；第二重从开始节点往下连续寻找路径和
执行用时：40 ms, 在所有 Java 提交中击败了5.65% 的用户
内存消耗：38.3 MB, 在所有 Java 提交中击败了74.63% 的用户
*/
class Solution {
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return pathSumStartAtRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);   //选取就找；不选就往下
    }
    public int pathSumStartAtRoot(TreeNode root, int sum) {
        if(root == null) return 0;
        return (root.val == sum ? 1 : 0) + pathSumStartAtRoot(root.left, sum - root.val) + pathSumStartAtRoot(root.right, sum - root.val);  // 如果相等也得往下找
    }
}

