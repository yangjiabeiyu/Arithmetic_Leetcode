/*
94. 二叉树的中序遍历
https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
给定一个二叉树的根节点 root ，返回它的 中序 遍历。
*/

/*
执行用时：1 ms, 在所有 Java 提交中击败了42.83% 的用户
内存消耗：36.6 MB, 在所有 Java 提交中击败了88.00% 的用户
*/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}

