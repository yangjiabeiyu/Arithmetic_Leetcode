/*
103. 二叉树的锯齿形层次遍历
https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

返回锯齿形层次遍历如下：
[
  [3],
  [20,9],
  [15,7]
]
*/

/*
解法：队列储存每层节点；双端链表储存节点的值：如果顺着读，就尾插，倒着读，就首插。
执行用时：1 ms, 在所有 Java 提交中击败了98.50% 的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了65.61% 的用户
*/
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            LinkedList<Integer> deque = new LinkedList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode p = queue.poll();
                if(res.size() % 2 == 0)     // 当前层是奇数层
                    deque.offerLast(p.val);
                else
                    deque.offerFirst(p.val);
                if(p.left != null) queue.offer(p.left);
                if(p.right != null) queue.offer(p.right);
            }
            res.add(deque);
        }
        return res;
    }
}

