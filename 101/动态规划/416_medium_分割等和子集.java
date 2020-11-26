/*
416. 分割等和子集
https://leetcode-cn.com/problems/partition-equal-subset-sum/
给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意:
    每个数组中的元素不会超过 100
    数组的大小不会超过 200

示例 1:
输入: [1, 5, 11, 5]
输出: true
解释: 数组可以分割成 [1, 5, 5] 和 [11].

示例 2:
输入: [1, 2, 3, 5]
输出: false
解释: 数组不能分割成两个元素和相等的子集.
*/

/*
解法一：动态规划
执行用时：31 ms, 在所有 Java 提交中击败了60.16% 的用户
内存消耗：39.2 MB, 在所有 Java 提交中击败了40.57% 的用户
*/
class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length < 2) return false;
        int sum = 0, n = nums.length;
        for(int i = 0; i < n; i++)
            sum += nums[i];
        if(sum % 2 == 1) return false;
        sum /= 2;
        boolean[][] dp = new boolean[n][sum + 1];
        if(nums[0] <= sum)    // 先处理边界
            dp[0][nums[0]] = true;
        else return false;
        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= sum; j++) {
                if(j >= nums[i])       // 如果装得下nums[i]就两方面考虑，装不下，就只能看前i-1个能否达到j
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
            if(dp[i][sum]) return true;         // 剪枝
        }
        return dp[n - 1][sum];   
    }
}

/*
解法二：空间优化，考虑到每次都需要上一轮次且在前面的数据，所以只能逆向更新。

*/


