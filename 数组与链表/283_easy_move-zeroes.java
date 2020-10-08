/*
移动零
https://leetcode-cn.com/problems/move-zeroes/
题目描述
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
示例
输入: [0,1,0,3,12]    输出: [1,3,12,0,0]
*/

/*
解法：双指针，一个遍历数组，一个存储不为0的元素，最后将0补全
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：39 MB, 在所有 Java 提交中击败了89.27% 的用户
*/
class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++)
            if(nums[i] != 0)
                nums[j++] = nums[i];
        while(j < nums.length)
            nums[j++] = 0;
    }
}
