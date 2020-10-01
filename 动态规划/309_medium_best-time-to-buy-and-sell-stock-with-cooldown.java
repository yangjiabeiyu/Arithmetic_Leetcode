/*
最佳买卖股票时机含冷冻期
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
题目描述
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格。
设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）；卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例
输入: [1,2,3,0,2]    输出: 3 
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
*/

/*
解法：当天结束时分为三个状态：
1、f[i][0]表示持有股票时的最大收益
2、f[i][1]表示未持有股票，且不能出售(冷冻期)时的最大收益
3、f[i][2]表示未持有股票，且可出售(非冷冻期)时的最大收益
情况1选择卖出，则会进入情况2;选择不卖，则会继续情况1;  
情况2只能选择不买，进入情况3;
情况3选择买入，则会进入情况1;不买入，则继续情况3;
因此有:f[i+1][0] = max{f[i][0], f[i][2]-price[i+1]}; f[i+1][1] = f[i][0] + price[i+1]; f[i+1][2] = max{f[i][1], f[i][2]}.
执行用时：2 ms, 在所有 Java 提交中击败了23.09% 的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了16.69% 的用户
*/

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int[][] mon = new int[prices.length][3];
        mon[0][0] = -prices[0];
        mon[0][1] = 0;
        mon[0][2] = 0;
        for(int i = 1; i < prices.length; i++) {
            mon[i][0] = Math.max(mon[i-1][0], mon[i-1][2] - prices[i]);
            mon[i][1] = mon[i-1][0] + prices[i];
            mon[i][2] = Math.max(mon[i-1][1], mon[i-1][2]);
        } 
        return Math.max(mon[prices.length-1][1], mon[prices.length-1][2]);
    }
}

/*
空间优化，迭代以不使用二维数组
执行用时：1 ms, 在所有 Java 提交中击败了99.56% 的用户
内存消耗：36.9 MB, 在所有 Java 提交中击败了82.57% 的用户
*/

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int case1 = -prices[0], case2 = 0, case3 = 0;
        int tempCase3;
        for(int i = 1; i < prices.length; i++) {
            tempCase3 = case3;
            case3 = Math.max(case2, case3);
            case2 = case1 + prices[i];
            case1 = Math.max(case1, tempCase3 - prices[i]);
        } 
        return Math.max(case2, case3);
    }
}

