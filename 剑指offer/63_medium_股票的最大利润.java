/*
剑指 Offer 63. 股票的最大利润

假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？

示例 1:
输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。

示例 2:
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
*/

/*
解法一：动态规划，dp[i]表示第i天卖出的最大利润，则dp[i-1] = nums[i-1]-min{i-1};所以dp[i] = nums[i] - min{i-1} = nums[i] - nums[i-1] + dp[i-1].
执行用时：2 ms, 在所有 Java 提交中击败了71.91% 的用户
内存消耗：38.2 MB, 在所有 Java 提交中击败了97.04% 的用户
*/
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int res = 0;
        int[] dp = new int[prices.length];
        dp[0] = 0;
        for(int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(0, dp[i-1] + prices[i] - prices[i-1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

/*
解法二：双指针，一个记录最小值，一个遍历数组
*/
class Solution {
    public int maxProfit(int[] prices) {
        int res = 0, minCost = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            minCost = Math.min(minCost, prices[i]);
            res = Math.max(res, prices[i] - minCost);
        }
        return res;
    }
}


