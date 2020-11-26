/*
300. 最长上升子序列
https://leetcode-cn.com/problems/longest-increasing-subsequence/
给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:
输入: [10,9,2,5,3,7,101,18]
输出: 4 
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。

说明:
    可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
    你算法的时间复杂度应该为 O(n2) 。

进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
*/

/*
解法一：动态规划
执行用时：73 ms, 在所有 Java 提交中击败了5.05% 的用户
内存消耗：38 MB, 在所有 Java 提交中击败了6.91% 的用户
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for(int i = 1; i < nums.length; i++) {
            dp[i] = 1;       // 注意这里要设置为1，每个单独的都是长度为1的序列
            for(int j = 0; j < i; j++)
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}

/*
解法二：维护一个有序数组，详解可见解析
执行用时：3 ms, 在所有 Java 提交中击败了80.87% 的用户
内存消耗：37.9 MB, 在所有 Java 提交中击败了8.02% 的用户
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        int len = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > dp[len])
                dp[++len] = nums[i];
            else {
                int left = 1, right = len - 1, pos = 0;
                while(left <= right) {
                    int mid = left + (right - left) / 2;
                    if(dp[mid] < nums[i]) {
                        pos = mid;
                        left = mid + 1;
                    }
                    else
                        right = mid - 1;
                }
                dp[pos + 1] = nums[i];
            }
        }
        return len;
    }
}

