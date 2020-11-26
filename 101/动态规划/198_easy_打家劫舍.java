/*
198. 打家劫舍
https://leetcode-cn.com/problems/house-robber/
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

示例 1：

输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。

示例 2：

输入：[2,7,9,3,1]
输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
*/

/*
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35.9 MB, 在所有 Java 提交中击败了74.82% 的用户
*/
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return dp[nums.length];
    }
}

/*
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35.8 MB, 在所有 Java 提交中击败了81.32% 的用户
*/
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        int pre1 = 0, pre2 = 0;
        for(int i = 0; i < nums.length; i++) {
            int temp = Math.max(pre2, pre1 + nums[i]);
            pre1 = pre2;
            pre2 = temp;
        }
        return pre2;
    }
}


