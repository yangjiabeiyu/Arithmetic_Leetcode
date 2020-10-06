/*
打家劫舍III
https://leetcode-cn.com/problems/house-robber-iii/
题目描述
在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 
除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
示例
示例 1:
输入: [3,2,3,null,3,null,1]
     3
    / \
   2   3
    \   \ 
     3   1
输出: 7 
解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
*/

/*
解法一：使用递归遍历每个节点，同时记录下以每个节点为入口时，能够盗取的最大金额。对于每个节点，只有两种情况：
1、盗取该节点，总钱数为该节点+左右子节点的子节点；
2、不盗取该节点，总钱数为左右子节点的加和。
执行用时：899 ms, 在所有 Java 提交中击败了15.70% 的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了76.70% 的用户
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
    public int rob(TreeNode root) {
        if(root == null)
            return 0;
        int v1 = root.val, v2 = 0;
        if(root.left != null)
            v1 += rob(root.left.right) + rob(root.left.left);
        if(root.right != null)
            v1 += rob(root.right.right) + rob(root.right.left);
        v2 = rob(root.left) + rob(root.right);
        return Math.max(v1, v2);
    }
}

/*
解法二：可以考虑每个节点处返回两个值，一个值为盗取该节点时获取的最大金额数val1；另一个值为不盗取时获取的最大金额数val2。
因此对于每个节点，只有两中情况：
1、当前val+左子节点的val2+右子节点的val2；
2、左右字节点的{val1和val2中的较大值}的加和(左右子节点可盗取可不盗取)
执行用时：1 ms, 在所有 Java 提交中击败了75.18% 的用户
内存消耗：38.7 MB, 在所有 Java 提交中击败了38.60% 的用户
*/

class Solution {
    public int rob(TreeNode root) {
        int[] v = nodeVal(root);
        return Math.max(v[0], v[1]);
    }
    public static int[] nodeVal(TreeNode root) {
        if(root == null)
            return new int[] {0, 0};
        int[] v1 = nodeVal(root.left);
        int[] v2 = nodeVal(root.right);
        int contains = root.val + v1[1] + v2[1];
        int notContains = Math.max(v1[0], v1[1]) + Math.max(v2[0], v2[1]);
        return new int[] {contains, notContains};
    }
}
