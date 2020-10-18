/*
把二叉搜索树转换为累加树
https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
提醒一下，二叉搜索树满足下列约束条件：

    节点的左子树仅包含键 小于 节点键的节点。
    节点的右子树仅包含键 大于 节点键的节点。
    左右子树也必须是二叉搜索树。

注意：本题和 1038: https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/ 相同
示例
输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
*/

/*
解法一：迭代，不断找到最右节点，过程中将节点压栈，然后弹栈，记录当前累加和，更新当前节点的val，然后继续找左子树。
执行用时：2 ms, 在所有 Java 提交中击败了15.30% 的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了99.19% 的用户
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode convertBST(TreeNode root) {
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();
        int curMax = 0;                           // 记录当前节点前面的累加和
        while(p != null || !stack.isEmpty()) {
            while(p != null) {                    // 后序遍历，找最右节点
                stack.push(p);
                p = p.right;
            }
            p = stack.pop();
            p.val += curMax;                      // 更新节点的val
            curMax = p.val;                       // 更新累加和
            p = p.left;                           // 左子树
        }
        return root;
    }
}

/*
解法二：递归，设置成员变量sum来记录累加和
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了99.65% 的用户
*/
class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null)
            return null;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}


/*
解法三：递归，设置参数
执行用时：1 ms, 在所有 Java 提交中击败了98.31% 的用户
内存消耗：38.4 MB, 在所有 Java 提交中击败了99.83% 的用户
*/
class Solution {
    public TreeNode convertBST(TreeNode root) {
        fun(root, 0);
        return root;
    }
    public int fun(TreeNode root, int sum) {
        if(root == null)
            return sum;
        root.val += fun(root.right, sum);
        return fun(root.left, root.val);
    }
}

