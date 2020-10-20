/*
剑指 Offer 54. 二叉搜索树的第k大节点

给定一棵二叉搜索树，请找出其中第k大的节点。
示例 1:
输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4
*/

/*
解法一：迭代
执行用时：2 ms, 在所有 Java 提交中击败了10.73% 的用户
内存消耗：37.8 MB, 在所有 Java 提交中击败了99.96% 的用户
*/
class Solution {
    public int kthLargest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            k--;
            if(k == 0)
                return root.val;
            root = root.left;
        }
        return 0;
    }
}


/*
解法二：递归，关键点在于用成员变量来记录k和res，递归可以类比迭代来写，相当于中序遍历的倒序
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.3 MB, 在所有 Java 提交中击败了95.57% 的用户
*/
class Solution {
    public int k;
    public int res;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return this.res;
    }
    public void dfs(TreeNode root) {
        if(root == null || k == 0)
            return;
        dfs(root.right);
        if(--k == 0)
            res = root.val;
        dfs(root.left);
    }
}



