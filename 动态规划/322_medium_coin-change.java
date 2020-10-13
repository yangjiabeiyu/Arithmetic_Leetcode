/*
零钱兑换
https://leetcode-cn.com/problems/coin-change/
题目描述
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
你可以认为每种硬币的数量是无限的。
提示：
    1 <= coins.length <= 12
    1 <= coins[i] <= 231 - 1
    0 <= amount <= 104
示例
输入：coins = [1, 2, 5], amount = 11    输出：3 
解释：11 = 5 + 5 + 1
输入：coins = [1], amount = 0    输出：0
*/

/*
解法：动态规划，dp[i]定义为构成金额i所需的最少硬币数，则只需要遍历所有硬币面值即可。
执行用时：14 ms, 在所有 Java 提交中击败了86.65% 的用户
内存消耗：38.6 MB, 在所有 Java 提交中击败了42.82% 的用户
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i = 1; i < amount + 1; i++) {
            // 先设置一个最大值，因为硬币面值不小于1，所以最多是amount；
            // 为了区分是使用了n个1，还是根本构不成，这里就设置为amount + 1；注意这里设置为max_value是不行的，后续min(max_value, 1+max_value)的返回值竟然是-2147483648
            dp[i] = amount + 1;   
            for(int j = 0; j < coins.length; j++)
                if(coins[j] <= i)
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);    // 如果硬币面值是不大于当前的i，那么就更新最小值。
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
