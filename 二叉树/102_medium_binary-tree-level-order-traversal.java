/*
二叉树的层序遍历
https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
题目描述
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
示例
二叉树：[3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：
[
  [3],
  [9,20],
  [15,7]
]
*/

/*
解法：使用双队列，出队的时候，把左右孩子入队；也可以单队列，使用size()方法获取每层的节点数。
执行用时：1 ms, 在所有 Java 提交中击败了92.96% 的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了98.95% 的用户
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        queue1.offer(root);
        while(!queue1.isEmpty()) {
            Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
            List list = new ArrayList();
            while(!queue1.isEmpty()) {     // 这里可以通过size()方法获取queue1的长度，其实也就是当前层的节点数，然后写for循环
                TreeNode p = queue1.poll();
                list.add(p.val);
                if(p.left != null)
                    queue2.add(p.left);
                if(p.right != null)
                    queue2.add(p.right);
            }
            lists.add(list);
            queue1 = queue2;
        }
        return lists;
    }
}
