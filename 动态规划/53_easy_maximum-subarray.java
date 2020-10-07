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

/*
空间优化
执行用时：1 ms, 在所有 Java 提交中击败了95.93% 的用户
内存消耗：39.1 MB, 在所有 Java 提交中击败了13.97% 的用户
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, res = nums[0], cur = nums[0];
        for(int i = 1; i < n; i++) {
            cur = Math.max(cur + nums[i], nums[i]);
            res = Math.max(cur, res);
        }
        return res;
    }
}

/*
解法二：贪婪算法，从头开始找，一旦加和小于0，那么就重新找
执行用时：1 ms, 在所有 Java 提交中击败了95.93% 的用户
内存消耗：38.8 MB, 在所有 Java 提交中击败了61.04% 的用户
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, res = Integer.MIN_VALUE, sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            res = Math.max(res, sum);
            sum = Math.max(sum, 0);
        }
        return res;
    }
}
