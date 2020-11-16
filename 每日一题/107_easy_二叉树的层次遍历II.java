/*
107. 二叉树的层次遍历 II
https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

返回其自底向上的层次遍历为：

[
  [15,7],
  [9,20],
  [3]
]
*/

/*
解法：结果保存时，首插即可
执行用时：1 ms, 在所有 Java 提交中击败了98.44% 的用户
内存消耗：38.1 MB, 在所有 Java 提交中击败了99.75% 的用户
*/
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode p = queue.poll();
                list.add(p.val);
                if(p.left != null) queue.offer(p.left);
                if(p.right != null) queue.offer(p.right);
            }
            res.add(0, list);
        }
        return res;
    }
}


