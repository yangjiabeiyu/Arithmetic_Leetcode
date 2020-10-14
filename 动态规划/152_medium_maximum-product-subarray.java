/*
乘积最大子数组
https://leetcode-cn.com/problems/maximum-product-subarray/
给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
示例
输入: [2,3,-2,4]    输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
*/

/*
解法：动态规划
*/
class Solution {
    public int maxProduct(int[] nums) {
        // 动态规划  dp[i]表示包含i的子数组的最大乘积，则有dp[i] = max{dp[i], dp[i-1]*nums[i]}
        // dp[i][0]表示负乘积 dp[i][1]表示正乘积
        int[][] dp = new int[nums.length + 1][2]; 
        dp[0][0] = 1;
        dp[0][1] = 1;
        int res = Integer.MIN_VALUE;
        for(int i = 1; i <= nums.length; i++) {
            dp[i][0] = Math.min(dp[i-1][0] * nums[i-1], Math.min(nums[i-1], dp[i-1][1] * nums[i-1]));
            dp[i][1] = Math.max(dp[i-1][0] * nums[i-1], Math.max(nums[i-1], dp[i-1][1] * nums[i-1]));
            res = Math.max(res, dp[i][1]);
        }
        return res;
    }
}

