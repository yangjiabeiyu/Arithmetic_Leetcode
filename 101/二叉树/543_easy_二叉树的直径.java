/*
543. 二叉树的直径
https://leetcode-cn.com/problems/diameter-of-binary-tree/
给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。

示例 :
给定二叉树
          1
         / \
        2   3
       / \     
      4   5    
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
*/

/*
解法：使用变量记录最大值即可。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.4 MB, 在所有 Java 提交中击败了78.63% 的用户
*/
class Solution {
    int maxNum = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        func(root);
        return maxNum;
    }
    public int func(TreeNode root) {
        if(root == null)
            return 0;
        int left = func(root.left), right = func(root.right);
        maxNum = Math.max(maxNum, left + right);
        return Math.max(left, right) + 1;
    }
}

