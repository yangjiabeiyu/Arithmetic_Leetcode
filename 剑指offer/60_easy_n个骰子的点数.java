/*
剑指 Offer 60. n个骰子的点数
https://leetcode-cn.com/problems/nge-tou-zi-de-dian-shu-lcof/
把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。

你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。

示例 1:
输入: 1
输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]

示例 2:
输入: 2
输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]

限制：
1 <= n <= 11
*/

/*
解法：动态规划
记dp[n][m]为n个骰子组成m的概率，dp[n][m] = dp[n-1][m-6]*1/6+dp[n-1][m-5]*1/6+……+dp[n-1][m-1]*1/6
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.8 MB, 在所有 Java 提交中击败了16.93% 的用户
*/
class Solution {
    public double[] twoSum(int n) {
        double p = 1.0 / 6;
        double[] pre = {1.0 / 6, 1.0 / 6, 1.0 / 6, 1.0 / 6, 1.0 / 6, 1.0 / 6};
        // double[] pre = new double[6];
        // Arrays.fill(pre, p);
        for(int i = 1; i < n; i++) {
            double[] cur = new double[5 * i + 6];
            for(int j = 0; j < pre.length; j++)  // 每个pre中的元素都会影响到后面的6个元素
                for(int k = 0; k < 6; k++)
                    cur[j + k] += pre[j] * p;
            pre = cur;
        }
        return pre;
    }
}

