/*
剑指 Offer 34. 二叉树中和为某一值的路径
https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1

返回:
[
   [5,4,11,2],
   [5,8,4,5]
]
*/

/*
解法：递归回溯，先序遍历，如果满足是叶子节点，而且恰好总和为sum，那么就把路径加入res；当然在尝试过后也需要把该节点在路径中删除。
执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.9 MB, 在所有 Java 提交中击败了91.33% 的用户
*/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        fun(root, sum);
        return res;
    }
    public void fun(TreeNode root, int sum) {
        if(root == null)
            return;
        path.add(root.val);
        if(root.left == null && root.right == null && root.val == sum)
            res.add(new ArrayList(path));
        fun(root.left, sum - root.val);
        fun(root.right, sum - root.val);
        path.remove(path.size() - 1);
    }
}


