/*
完全平方数
https://leetcode-cn.com/problems/perfect-squares/
题目描述
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
示例
输入: n = 12    输出: 3 
解释: 12 = 4 + 4 + 4.
*/

/*
解法：动态规划，dp[i]表示最少的个数，那么有dp[i] = min{1 + dp[i - k*k]}, 对所有正整数k，k*k<=i
执行用时：46 ms, 在所有 Java 提交中击败了43.32% 的用户
内存消耗：38 MB, 在所有 Java 提交中击败了82.57% 的用户
*/
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for(int i = 1; i < n + 1; i++) {
            dp[i] = Integer.MAX_VALUE;  // 先设置为最大值
            for(int j = 1; j * j <= i; j++)
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
        }
        return dp[n];
    }
}
