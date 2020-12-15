/*
144. 二叉树的前序遍历
https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
*/

/*
执行用时：1 ms, 在所有 Java 提交中击败了41.12% 的用户
内存消耗：36.8 MB, 在所有 Java 提交中击败了42.66% 的用户
*/
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop().right;
        }
        return res;
    }
}

