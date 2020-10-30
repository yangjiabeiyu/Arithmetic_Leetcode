/*
268. 丢失的数字
https://leetcode-cn.com/problems/missing-number/
给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。

进阶：
    你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?

示例 1：
输入：nums = [3,0,1]
输出：2
解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。

示例 2：

输入：nums = [0,1]
输出：2
解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。

提示：
    n == nums.length
    1 <= n <= 104
    0 <= nums[i] <= n
    nums 中的所有数字都 独一无二
*/

/*
解法一：异或，只需要把0~n与数组中的数字都异或一遍，最终结果就是缺失的数字。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：39.1 MB, 在所有 Java 提交中击败了75.49% 的用户
*/
class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for(int i = 1; i <= nums.length; i++)
            res ^= i ^ nums[i - 1];
        return res;
    }
}

/*
解法二：求和，求出0~n的和以及数组中的数字和，相减就是缺失的数字
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：39.4 MB, 在所有 Java 提交中击败了46.59% 的用户
*/
class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        for(int i = 1; i <= nums.length; i++)
            res += i - nums[i - 1];
        return res;
    }
}

