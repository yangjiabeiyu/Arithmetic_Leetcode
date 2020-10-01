/*
打家劫舍II
https://leetcode-cn.com/problems/house-robber-ii/
题目描述
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
示例
输入: [2,3,2]    输出: 3
解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
*/

/*
解法：分为两种情况，偷窃第一家，那么不能偷窃第n家；不偷窃第一家，那么可以偷窃第n家，因此可以将环形拆为两个数组：1~n-1和2~n
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：36.2 MB, 在所有 Java 提交中击败了67.08% 的用户
*/
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        else if(nums.length == 1)
            return nums[0];
        return Math.max(rob(nums, 0), rob(nums, 1));
        
    }
    public int rob(int[] nums, int start) {
        int[] mon = new int[nums.length];
        mon[0] = 0;
        mon[1] = nums[start];
        for(int i = 1; i < nums.length - 1; i++)
            mon[i + 1] = Math.max(nums[start + i] + mon[i-1], mon[i]);
        return mon[nums.length - 1];
    }
}

/*
改进1：可以迭代来代替数组，降低空间复杂度
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：36.4 MB, 在所有 Java 提交中击败了30.87% 的用户
*/
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)
            return 0;
        else if(nums.length == 1)
            return nums[0];
        return Math.max(rob(nums, 0), rob(nums, 1));
        
    }
    public int rob(int[] nums, int start) {
        int resOld = 0, res = nums[start], resNew;
        for(int i = 1; i < nums.length - 1; i++) {
            resNew = Math.max(nums[start + i] + resOld, res);
            resOld = res;
            res = resNew;
        }
        return res;
    }
}


/*
改进2：如果初值设为0和0，那么可以不用讨论数组长度为0的情况
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：36.5 MB, 在所有 Java 提交中击败了16.45% 的用户
*/
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        return Math.max(rob(nums, 0), rob(nums, 1));    
    }
    public int rob(int[] nums, int start) {
        int resOld = 0, res = 0, resNew;
        for(int i = 1; i < nums.length; i++) {
            resNew = Math.max(nums[start + i - 1] + resOld, res);
            resOld = res;
            res = resNew;
        }
        return res;
    }
}
