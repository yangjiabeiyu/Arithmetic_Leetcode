/*
不同的二叉搜索树
https://leetcode-cn.com/problems/unique-binary-search-trees/
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
示例:
输入: 3    输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

/*
解法：动态规划
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35 MB, 在所有 Java 提交中击败了99.00% 的用户
*/
class Solution {
    public int numTrees(int n) {
        // 动态规划：G(n) = sigma F(n, i),对i从1到n。G(n)代表n个节点所有的可能性，F(n,i)代表以i为根节点的种类数
        // 对于以i为根节点的情况，左边会有1~i-1，右边会有i+1~n，所以有F(n,i) = G(i-1)*G(n-i)
        int[] num = new int[n + 1];
        num[0] = 1;
        num[1] = 1;
        for(int i = 2; i <= n; i++)
            for(int j = 1; j <= i; j++)
                num[i] += num[j - 1] * num[i - j];
        return num[n];
    }
}
