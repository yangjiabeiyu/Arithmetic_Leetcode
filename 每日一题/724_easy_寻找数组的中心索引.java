/*
724. 寻找数组的中心索引
给你一个整数数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
https://leetcode-cn.com/problems/find-pivot-index/
数组 中心索引 是数组的一个索引，其左侧所有元素相加的和等于右侧所有元素相加的和。
如果数组不存在中心索引，返回 -1 。如果数组有多个中心索引，应该返回最靠近左边的那一个。
注意：中心索引可能出现在数组的两端。

示例 1：
输入：nums = [1, 7, 3, 6, 5, 6]
输出：3
解释：
索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
同时, 3 也是第一个符合要求的中心索引。
*/

/*
解法一：计算从后到前的前缀和，然后从前往后看看什么时候相等
执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
内存消耗：39.1 MB, 在所有 Java 提交中击败了59.54%的用户
*/
class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length, cur_sum = 0;
        int[] sum = new int[n + 1];
        for(int i = n - 1; i >= 0; --i)
            sum[i] = sum[i + 1] + nums[i];
        for(int i = 0; i < n; ++i) {
            if(cur_sum == sum[i + 1])
                return i;
            cur_sum += nums[i];
        }
        return -1;
    }
}

/*
解法二：计算数组和，然后遍历看看有没有分隔点即可
执行用时：2 ms, 在所有 Java 提交中击败了55.66%的用户
内存消耗：39.1 MB, 在所有 Java 提交中击败了56.19%的用户
*/
class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length, cur_sum = 0, sum = 0;
        for(int i : nums)
            sum += i;
        for(int i = 0; i < n; ++i) {
            if(2 * cur_sum + nums[i] == sum)
                return i;
            cur_sum += nums[i];
        }
        return -1;
    }
}

