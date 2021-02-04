/*
113. 路径总和 II
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
https://leetcode-cn.com/problems/path-sum-ii/
说明: 叶子节点是指没有子节点的节点。
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
解法一：回溯
执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：39 MB, 在所有 Java 提交中击败了29.15%的用户
*/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return res;
        dfs(root, targetSum);
        return res;
    }
    public void dfs(TreeNode root, int targetSum) {
        if(root.left == null && root.right == null) {
            if(root.val == targetSum) {
                path.add(targetSum);
                res.add(new LinkedList<Integer>(path));
                path.removeLast();
            }
            return;
        }
        path.add(root.val);
        if(root.left != null)
            dfs(root.left, targetSum - root.val);
        if(root.right != null)
            dfs(root.right, targetSum - root.val);
        path.removeLast();
    }
}

/*
另外一种写法
执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：38.8 MB, 在所有 Java 提交中击败了61.02%的用户
*/
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }
    public void dfs(TreeNode root, int targetSum) {
        if(root == null) return;
        if(root.left == null && root.right == null && root.val == targetSum) {
            path.add(targetSum);
            res.add(new LinkedList<Integer>(path));
            path.removeLast();
            return;
        }
        path.add(root.val);
        dfs(root.left, targetSum - root.val);
        dfs(root.right, targetSum - root.val);
        path.removeLast();
    }
}

