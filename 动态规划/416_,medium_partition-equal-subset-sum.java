/*
分割等和子集
https://leetcode-cn.com/problems/partition-equal-subset-sum/
题目描述
给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
注意:
    每个数组中的元素不会超过 100
    数组的大小不会超过 200
示例
输入: [1, 5, 11, 5]    输出: true
解释: 数组可以分割成 [1, 5, 5] 和 [11].
*/

/*
解法：动态规划，同样是背包问题，dp[i][j]表示前i个元素是否可以加和为j，dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]；前者表示选择nums[i]，后者表示不选择。
执行用时：52 ms, 在所有 Java 提交中击败了21.05% 的用户
内存消耗：39.7 MB, 在所有 Java 提交中击败了5.88% 的用户
*/
class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length <= 1)
            return false;
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            sum += nums[i];
        if(sum % 2 == 1)
            return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length][target + 1];
        if(nums[0] <= target)
            dp[0][nums[0]] = true;
        for(int i = 1; i < nums.length; i++) {
            for(int j = 1; j < target + 1; j++) {
                if(j - nums[i] > 0)
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[nums.length - 1][target];    
    }
}

/*
优化：用一个一维数组即可
执行用时：32 ms, 在所有 Java 提交中击败了53.74% 的用户
内存消耗：37.9 MB, 在所有 Java 提交中击败了62.99% 的用户
*/
class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length <= 1)
            return false;
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            sum += nums[i];
        if(sum % 2 == 1)
            return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        if(nums[0] <= target)
            dp[nums[0]] = true;
        for(int i = 1; i < nums.length; i++)
            for(int j = target; j > 0; j--)
                if(j - nums[i] > 0)
                    dp[j] = dp[j - nums[i]] || dp[j];
                else
                    dp[j] = dp[j];
        return dp[target];    
    }
}


/*
优化二：事实上，一维数组的循环不必那么多，毕竟小于nums[i]的部分不是必需的
执行用时：24 ms, 在所有 Java 提交中击败了63.19% 的用户
内存消耗：38.3 MB, 在所有 Java 提交中击败了61.16% 的用户
*/
class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length <= 1)
            return false;
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            sum += nums[i];
        if(sum % 2 == 1)
            return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;  // 此处设置是很巧妙的，后续公式中，j=nums[i]的时候，只选该元素即可，所以要设置为true
        for(int i = 0; i < nums.length; i++)
            for(int j = target; j >= nums[i]; j--)
                dp[j] |= dp[j - nums[i]];  // 对于目标值小于 nums[j] 的元素，只能靠前面的元素了
        return dp[target];    
    }
}
