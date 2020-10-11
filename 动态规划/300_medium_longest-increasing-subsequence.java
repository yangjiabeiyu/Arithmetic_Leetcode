/*
最长上升子序列
https://leetcode-cn.com/problems/longest-increasing-subsequence/
题目描述
给定一个无序的整数数组，找到其中最长上升子序列的长度。
示例
输入: [10,9,2,5,3,7,101,18]    输出: 4 
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4；严格上升。
*/

/*
解法一：动态规划，dp[i]表示以nums[i]结尾时的最长上升子序列，所以有dp[i] = max{dp[j] + 1}，对j < i且nums[j] < nums[i]
执行用时：16 ms, 在所有 Java 提交中击败了24.58% 的用户
内存消耗：37.1 MB, 在所有 Java 提交中击败了6.60% 的用户
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxLen = 1;
        for(int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++)
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }
}

/*
解法二：维护数组dp[k]，表示长度为k的上升子序列的末尾元素最小值，同时维护数组的长度len；遍历数组：
如果nums[i] > dp[len]，那么就说明能够有更长的子序列，len++，dp[len+1] = nums[i]；
如果nums[i] <= dp[len]，那么就找到dp中首个小于nums[i]的元素，即dp[k] < nums[j]，然后dp[k+1] = nums[j]，
这也说明原来的长度为k的子序列加上了nums[i]，可以够成长度为k+1的子序列，且末尾元素比原来的dp[k+1]要小，后续可以在此基础上继续覆盖；
dp数组显然是升序的，所以可以二分查找来降低复杂度。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：36.4 MB, 在所有 Java 提交中击败了99.18% 的用户
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        int len = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > dp[len])
                dp[++len] = nums[i];
            else {
                int left = 1, right = len - 1, pos = 0;
                while(left <= right) {
                    int mid = (left + right) >> 1;
                    if(dp[mid] < nums[i]) {
                        pos = mid;
                        left = mid + 1;
                    }
                    else
                        right = mid - 1;
                }
                dp[++pos] = nums[i];
            }
        }
        return len;
    }
}
