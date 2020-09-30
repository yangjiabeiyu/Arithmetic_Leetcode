/*
删除排序数组中的重复项
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

题目描述
给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。不要使用额外的数组空间，你必须在原地修改输入数组 并在使用 O(1) 额外空间的条件下完成。

示例
给定 nums = [0,0,1,1,1,2,2,3,3,4],函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。你不需要考虑数组中超出新长度后面的元素。

解题思路
从数组的第二个元素开始，不用考虑边界；双指针遍历，第一个指针遍历数组，第二个指针停留在数组头部；如遇到相同的数字，则指针一前移；否则，指针二前移，并记录下指向的数字。
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        int res = 0;  
        for(int i = 1; i < nums.length; i++) {
            if(nums[res] != nums[i]){
                nums[++res] = nums[i];
            }
        }
        return res + 1;
    }
}
