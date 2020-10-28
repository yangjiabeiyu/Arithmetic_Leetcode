/*
122. 买卖股票的最佳时机 II
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
示例 1:
输入: [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。

示例 2:
输入: [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。

示例 3:
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
*/

/*
解法：动态规划, dp[i][0]当晚持有股票的最大收益，dp[i][1]没有股票的最大收益；
则dp[i+1][0] = max{dp[i][0], dp[i][1] - prices[i+1]};
dp[i+1][1] = max{dp[i][1], dp[i][0] + prices[i+1]};
执行用时：4 ms, 在所有 Java 提交中击败了13.34% 的用户
内存消耗：38.1 MB, 在所有 Java 提交中击败了96.68% 的用户
*/
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for(int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }
}

/*
解法二：不需要动态规划。如果当天价格高于昨天，那么昨天买今天卖就行了，所以只需要找到这种增区间，求个加和就行。
执行用时：1 ms, 在所有 Java 提交中击败了99.56% 的用户
内存消耗：37.8 MB, 在所有 Java 提交中击败了99.15% 的用户
*/
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for(int i = 1; i < prices.length; i++)
            if(prices[i] > prices[i - 1])
                res += prices[i] - prices[i - 1];
        return res;
    }
}


