/*
剑指 Offer 26. 树的子结构

输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
B是A的子结构， 即 A中有出现和B相同的结构和节点值。

例如:
给定的树 A:

     3
    / \
   4   5
  / \
 1   2
给定的树 B：

   4 
  /
 1
返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。

示例 1：
输入：A = [1,2,3], B = [3,1]
输出：false
*/

/*
解法：递归，一个判断当前子树是否匹配，主函数遍历入口。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：39.9 MB, 在所有 Java 提交中击败了97.45% 的用户
*/
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A == null || B == null)
            return false;
        if(fun(A, B))
            return true;
        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    public boolean fun(TreeNode A, TreeNode B) {
        if(B == null)
            return true;
        if(A == null || A.val != B.val)
            return false;
        return fun(A.left, B.left) && fun(A.right, B.right);
    }
}

