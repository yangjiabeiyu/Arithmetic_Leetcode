/*
打家劫舍
https://leetcode-cn.com/problems/house-robber/
题目描述
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
示例
输入：[2,7,9,3,1]    输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。偷窃到的最高金额 = 2 + 9 + 1 = 12 。
*/

/*
解法一：设置一维数组mon，第i个元素表示存储窃取前i个屋子，获取最多的现金；
如果偷第i个房间，那么最多获得mon(i-2)+nums(i)，不偷则最多mon(i-1)，因此有mon(i) = max{mon(i-2)+nums(i), mon(i-1)}
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：36.6 MB, 在所有 Java 提交中击败了7.08% 的用户
*/
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] mon = new int[nums.length + 1];
        mon[0] = 0;
        mon[1] = nums[0];
        for(int i = 1; i < nums.length; i++)
            mon[i + 1] = Math.max(nums[i] + mon[i-1], mon[i]);
        return mon[nums.length];
    }
}

/*
优化：可以简化空间，因为有递推关系，因此只需要迭代得到最大值即可
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：36.1 MB, 在所有 Java 提交中击败了76.01% 的用户
*/
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        int res = nums[0], resOld = 0, resNew;
        for(int i = 1; i < nums.length; i++) {
            resNew = Math.max(nums[i] + resOld, res);
            resOld = res;
            res = resNew;
        }     
        return res;
    }
}
