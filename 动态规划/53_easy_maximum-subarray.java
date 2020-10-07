/*
最大子序和
https://leetcode-cn.com/problems/maximum-subarray/
题目描述
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
示例
输入: [-2,1,-3,4,-1,2,1,-5,4]    输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
*/

/*
解法一：动态规划，dp[i]表示以nums[i]为结尾的子数组的最大值，同时记录一下dp[i]的最大值。
执行用时：2 ms, 在所有 Java 提交中击败了11.82% 的用户
内存消耗：38.8 MB, 在所有 Java 提交中击败了64.41% 的用户
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, res = nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
