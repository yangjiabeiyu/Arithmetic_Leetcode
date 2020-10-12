/*
目标和
https://leetcode-cn.com/problems/target-sum/
题目描述
给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
示例
输入：nums: [1, 1, 1, 1, 1], S: 3    输出：5
解释：
-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3
一共有5种方法让最终目标和为3。
*/

/*
解法一：递归
执行用时：357 ms, 在所有 Java 提交中击败了42.12% 的用户
内存消耗：36.4 MB, 在所有 Java 提交中击败了90.93% 的用户
*/
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length == 0)
            return 0;
        return fun(nums, S, 0);
    }
    public int fun(int[] nums, int S, int pos) {
        if(pos == nums.length - 1)
            if(nums[pos] == 0 && S == 0)   // 对于0来说是两种，可加可减
                return 2;
            else if(nums[pos] == Math.abs(S))   //对非零数字，只有一种，要么加要么减
                return 1;
            else
                return 0;
        return fun(nums, S + nums[pos], pos + 1) + fun(nums, S - nums[pos], pos + 1);
    }
}


/*
解法二：动态规划，背包问题，定义dp[i][j]为前i个数字经过±操作得到j的方法数，所以有dp[i][j] = dp[i-1][j-nums[i]] + dp[i-1][j+nums[i]]；
但考虑到j可能正也可能为负，所以需要计算绝对值加和 s，然后创建列长度2*s + 1的数组。
执行用时：24 ms, 在所有 Java 提交中击败了49.78% 的用户
内存消耗：38.7 MB, 在所有 Java 提交中击败了30.58% 的用户
*/
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length == 0)
            return 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            sum += Math.abs(nums[i]);
        if(sum < Math.abs(S))
            return 0;
        int[][] dp = new int[nums.length][2 * sum + 1];
        dp[0][sum + nums[0]]++;   // 初始化
        dp[0][sum - nums[0]]++;   // 初始化
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < 2 * sum + 1; j++) {
                if(j - nums[i] >= 0 && j - nums[i] <= 2 * sum)   // 判断位置的合理性
                    dp[i][j] += dp[i - 1][j - nums[i]];
                if(j + nums[i] >= 0 && j + nums[i] <= 2 * sum)
                    dp[i][j] += dp[i - 1][j + nums[i]];
            }
        }
        return dp[nums.length - 1][sum + S];
    }
}

/*
优化思路一：判断是否到达了dp[nums.length-1][sum+S]，到达即停止。
执行用时：18 ms, 在所有 Java 提交中击败了51.66% 的用户
内存消耗：38.3 MB, 在所有 Java 提交中击败了37.32% 的用户
*/
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length == 0)
            return 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            sum += Math.abs(nums[i]);
        if(sum < Math.abs(S))
            return 0;
        int[][] dp = new int[nums.length][2 * sum + 1];
        dp[0][sum + nums[0]]++;
        dp[0][sum - nums[0]]++;
        for(int i = 1; i < nums.length; i++) {
            for(int j = 0; j < 2 * sum + 1; j++) {
                if(j - nums[i] >= 0 && j - nums[i] <= 2 * sum)
                    dp[i][j] += dp[i - 1][j - nums[i]];
                if(j + nums[i] >= 0 && j + nums[i] <= 2 * sum)
                    dp[i][j] += dp[i - 1][j + nums[i]];
                if(i == nums.length - 1 && j == sum + S)
                    return dp[i][j];
            }
        }
        return dp[nums.length - 1][sum + S];
    }
}

/*
优化思路二：每次迭代只需要两行，所以可以用两个一维数组进行迭代
执行用时：11 ms, 在所有 Java 提交中击败了66.87% 的用户
内存消耗：38.6 MB, 在所有 Java 提交中击败了32.98% 的用户
*/
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length == 0)
            return 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++)
            sum += Math.abs(nums[i]);
        if(sum < Math.abs(S))
            return 0;
        int[] dp1 = new int[2 * sum + 1];
        dp1[sum + nums[0]]++;
        dp1[sum - nums[0]]++;
        for(int i = 1; i < nums.length; i++) {
            int[] dp2 = new int[2 * sum + 1];
            for(int j = 0; j < 2 * sum + 1; j++) {
                if(j - nums[i] >= 0)
                    dp2[j] += dp1[j - nums[i]];
                if(j + nums[i] <= 2 * sum)
                    dp2[j] += dp1[j + nums[i]];
                // if(i == nums.length - 1 && j == sum + S)
                //     return dp2[j];
                
            }
            dp1 = dp2;
        }
        return dp1[sum + S];
    }
}
