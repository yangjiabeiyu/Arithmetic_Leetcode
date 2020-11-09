/*
41. 缺失的第一个正数
https://leetcode-cn.com/problems/first-missing-positive/
给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。

示例 1:
输入: [1,2,0]
输出: 3

示例 2:
输入: [3,4,-1,1]
输出: 2

示例 3:
输入: [7,8,9,11,12]
输出: 1

提示：
你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
*/

/*
解法：首先需要明确的是，答案必然是在1~n+1的。对于≤0的数字，可以都先调整为n+1；再次遍历，如果nums[i]≤n，那么就在num[i] - 1处，将对应值置反；
然后再次遍历，如果遇到的数字大于0，这就说明该索引没有进行置反操作，因此该索引值+1即是想要的答案。
*/
class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;
        int n = nums.length;
        for(int i = 0; i < n; i++)
            if(nums[i] <= 0)
                nums[i] = n + 1;
        for(int i = 0; i < n; i++) {
            int temp = Math.abs(nums[i]);
            if(temp <= n)
                nums[temp - 1] = -Math.abs(nums[temp - 1]);
        }
        for(int i = 0; i < n; i++)
            if(nums[i] > 0)
                return i + 1;
        return n + 1;        // 如果都小于0，这就说明1~n中的数字都遍历到了。
    }
}

