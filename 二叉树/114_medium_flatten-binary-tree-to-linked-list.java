/*
二叉树展开为链表
https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
题目描述
给定一个二叉树，原地将它展开为一个单链表。
示例
给定二叉树
    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
*/

/*
解法一：递归，每次返回左子树flatten后的尾节点，尾节点后连上右子树，整体再作为右子树。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：37.8 MB, 在所有 Java 提交中击败了99.98% 的用户
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
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        fun(root);
    }
    public TreeNode fun(TreeNode root) {
        if(root.left == null && root.right == null)
            return root;
        if(root.left != null && root.right == null) {
            TreeNode p = fun(root.left);   // 先拿到左子树flatten后的尾节点，用于返回
            root.right = root.left;        // 左子树给到右子树
            root.left = null;              // 把左子树置空
            return p;                      // 返回尾节点
        }
        if(root.left == null && root.right != null)
            return fun(root.right);        // 直接返回flatten右子树的尾节点
        TreeNode p = fun(root.left);       // 若左右子树都不为空，那么先得到左右子树flatten后的尾节点
        TreeNode q = fun(root.right);
        p.right = root.right;              // 左侧尾节点后面加上右子树
        root.right = root.left;            // 然后把左子树置为新的右子树
        root.left = null;                  // 把左子树置为null
        return q;                          // 返回原右子树的尾节点，其实也就是当前节点及所有子节点flatten后的尾节点
    }
}

/*
解法二：一直向右找，如果有左子树，就先找到左子树中的尾节点，然后把当前节点的右子树接到尾节点上，最后把整个左子树作为右子树，左子树置空
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.1 MB, 在所有 Java 提交中击败了99.76% 的用户
*/
class Solution {
    public void flatten(TreeNode root) {
        while(root != null) {
            if(root.left != null) {    // 如果左子树存在，那么就找到当前节点右子树的直接前继
                TreeNode pre = root.left;
                while(pre.right != null)   // 一直向右找
                    pre = pre.right;
                pre.right = root.right;    // 先将右子树给前继的右子树
                root.right = root.left;    // 然后把左子树给到右子树
                root.left = null;          // 左子树置null
            }
            root = root.right;             // 继续向下
        }
        return;
    }
}

/*
解法三：递归，倒序寻找，先找最右边的，然后记录下来当前的节点，然后接到上一节点的右子树。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：37.7 MB, 在所有 Java 提交中击败了99.98% 的用户
*/
class Solution {
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if(root == null)
            return;
        flatten(root.right);   // 先更新右子树的pre
        flatten(root.left);    // 然后到左子树中，把右子树的pre接到左子树的尾部(进入左子树后，会一直找左子树的右子树，然后最下面右子树的右子树设置为pre)
        root.right = pre;     
        root.left = null;
        pre = root;
    }
}   
