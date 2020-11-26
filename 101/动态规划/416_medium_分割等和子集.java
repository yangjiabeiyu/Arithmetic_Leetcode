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
解法一：动态规划；我一开始觉得代码是不对的，因为第一列应该先置为true，这样后续的j==nums[i]的时候才会将dp[i][j]置为true，否则可能不是true；
但通过了测试，后面我才明白，通过测试的原因就是：dp[0][nums[0]] = true，因为若能分为两份，其中一份必然是包含nums[0]的，所以只要它初始化为true，就能一直往后传递，得到true的结果。
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
执行用时：19 ms, 在所有 Java 提交中击败了87.02% 的用户
内存消耗：37.9 MB, 在所有 Java 提交中击败了82.86% 的用户
*/
class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length < 2) return false;
        int sum = 0, n = nums.length;
        for(int i = 0; i < n; i++)
            sum += nums[i];
        if(sum % 2 == 1) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for(int i = 0; i < n; i++) {
            for(int j = sum; j >= nums[i]; j--)   // 只需要到nums[i]
                    dp[j] |= dp[j - nums[i]];
            if(dp[sum]) return true;
        }
        return dp[sum];   
    }
}

