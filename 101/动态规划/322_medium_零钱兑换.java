/*
322. 零钱兑换
https://leetcode-cn.com/problems/coin-change/
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
你可以认为每种硬币的数量是无限的。

示例 1：
输入：coins = [1, 2, 5], amount = 11
输出：3 
解释：11 = 5 + 5 + 1

示例 2：
输入：coins = [2], amount = 3
输出：-1
*/

/*
完全背包问题
执行用时：13 ms, 在所有 Java 提交中击败了91.90% 的用户
内存消耗：37.9 MB, 在所有 Java 提交中击败了79.33% 的用户
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);   // 先给上最大值
        dp[0] = 0;
        for(int i = 0; i < coins.length; i++)
            for(int j = coins[i]; j <= amount; j++)
                dp[j] = Math.min(1 + dp[j - coins[i]], dp[j]);
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

/*
dp，外层是amount，然后遍历硬币面值。整体思路即是凑成dp[i]最少需要多少硬币
执行用时：14 ms, 在所有 Java 提交中击败了87.14% 的用户
内存消耗：37.9 MB, 在所有 Java 提交中击败了75.72% 的用户
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++)
            for(int coin : coins)
                if(i >= coin)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

