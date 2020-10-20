/*
剑指 Offer 55 - II. 平衡二叉树
输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

示例 1:
给定二叉树 [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7

返回 true 。


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
解法一：创建一个函数来得到左右子树最大深度，然后比较
执行用时：1 ms, 在所有 Java 提交中击败了99.98% 的用户
内存消耗：38.1 MB, 在所有 Java 提交中击败了99.80% 的用户
*/
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        return Math.abs(fun(root.left) - fun(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int fun(TreeNode node) {
        if(node == null)
            return 0;
        return 1 + Math.max(fun(node.left), fun(node.right));
    }
}


/*
解法二：解法一会有大量的重复计算，其实之所以那样是因为获取深度与判别是否平衡不能统一起来。如果平衡时返回深度。。不平衡返回-1，那么就可以将两者兼容。
执行用时：1 ms, 在所有 Java 提交中击败了99.98% 的用户
内存消耗：38.3 MB, 在所有 Java 提交中击败了98.13% 的用户
*/
class Solution {
    public boolean isBalanced(TreeNode root) {
        return fun(root) != -1;
    }
    public int fun(TreeNode root) {
        if(root == null)
            return 0;
        int num1 = fun(root.left);       // 分开判断，可以减少递归次数
        if(num1 == -1)
            return -1;
        int num2 = fun(root.right);
        if(num2 == -1)
            return -1;
        return Math.abs(num1 - num2) < 2 ? 1 + Math.max(num1, num2) : -1;
    }
}

