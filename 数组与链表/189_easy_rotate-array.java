/*
旋转数组
https://leetcode-cn.com/problems/rotate-array/
题目描述
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
示例:
输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
要求使用空间复杂度为 O(1) 的 原地 算法。
*/

/*
解法一：取出数组最后一个元素e，其余元素后移一位，再将e放到首元素位置，重复k次；复杂度O(k*n)
*/
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length <= 1)
            return;
        int flag, i, j; 
        for(j = 0; j < k; j++) {
            flag = nums[nums.length - 1];
            for(i = nums.length - 1; i > 0; i--)
                nums[i] = nums[i-1];
            nums[0] = flag;
        }
    }
}
