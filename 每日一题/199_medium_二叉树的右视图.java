/*
199. 二叉树的右视图
https://leetcode-cn.com/problems/binary-tree-right-side-view/
给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
示例:
输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
*/

/*
解法：层序遍历，记录最后一个
执行用时：2 ms, 在所有 Java 提交中击败了19.77% 的用户
内存消耗：36.7 MB, 在所有 Java 提交中击败了99.07% 的用户
*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            for(int i = queue.size(); i > 0; i--) {
                if(i == 1) res.add(queue.peek().val);
                TreeNode p = queue.poll();
                if(p.left != null) queue.offer(p.left);
                if(p.right != null) queue.offer(p.right);
            }
        }
        return res;
    }
}

/*
解法二：dfs，每次先往右边找，如果深度确实和res的长度相同，就加入。这里比较巧妙的就是使用res的长度来记录找到了第几层
执行用时：1 ms, 在所有 Java 提交中击败了99.00% 的用户
内存消耗：36.9 MB, 在所有 Java 提交中击败了84.69% 的用户
*/
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    public void dfs(TreeNode root, int depth) {
        if(root == null) return;
        if(depth == res.size()) res.add(root.val);
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }
}

