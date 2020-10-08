/*
买卖股票的最佳时机
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
题目描述
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
注意：你不能在买入股票前卖出股票。
示例
输入: [7,1,5,3,6,4]    输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
*/

/*
解法一：动态规划
执行用时：2 ms, 在所有 Java 提交中击败了63.60% 的用户
内存消耗：38.7 MB, 在所有 Java 提交中击败了63.86% 的用户
*/
class Solution {
    public int maxProfit(int[] prices) {
        // dp[i] 第i天卖出股票的最大收益
        // dp[i-1] = prices[i-1] - minValue(i-1); dp[i] = max(prices[i]-minValue(i-1), 0)
        // maxProfit = max(maxProfit, dp[i]);
        if(prices.length == 0)
            return 0;
        int profit = 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for(int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(0, dp[i-1]+prices[i]-prices[i-1]);
            profit = Math.max(profit, dp[i]);
        }
        return profit;
    }
}

