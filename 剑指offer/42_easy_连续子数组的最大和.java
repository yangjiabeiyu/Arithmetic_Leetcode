/*
剑指 Offer 42. 连续子数组的最大和

输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
要求时间复杂度为O(n)。

示例1:
输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
*/


/*
解法：dp[i]代表以nums[i]结尾的最大和，那么dp[i] = max{dp[i-1]+nums[i], nums[i]}
执行用时：1 ms, 在所有 Java 提交中击败了99.36% 的用户
内存消耗：44.8 MB, 在所有 Java 提交中击败了97.71% 的用户
*/
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0)
            return 0;
        int res = nums[0];
        int cur = nums[0];
        for(int i = 1; i < nums.length; i++) {
            cur = Math.max(nums[i], nums[i] + cur);
            res = Math.max(res, cur);
        }
        return res;
    }
}


