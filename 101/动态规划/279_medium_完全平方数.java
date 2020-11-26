/*
279. 完全平方数
https://leetcode-cn.com/problems/perfect-squares/
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:
输入: n = 12
输出: 3 
解释: 12 = 4 + 4 + 4.

示例 2:
输入: n = 13
输出: 2
解释: 13 = 4 + 9.
*/

/*
执行用时：50 ms, 在所有 Java 提交中击败了34.84% 的用户
内存消耗：37.4 MB, 在所有 Java 提交中击败了89.64% 的用户
*/
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        int num = 1, num2 = 1;;
        for(int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++)
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
        }
        return dp[n];
    }
}

