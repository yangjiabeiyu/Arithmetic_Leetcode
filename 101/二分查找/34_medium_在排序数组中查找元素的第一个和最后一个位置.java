/*
34. 在排序数组中查找元素的第一个和最后一个位置
https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值 target，返回 [-1, -1]。
进阶：
    你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？

示例 1：
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
*/

/*
解法：找到第一个位置，与target+1的第一个位置
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：41.8 MB, 在所有 Java 提交中击败了56.91% 的用户
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = searchFirst(nums, target);
        if(left == nums.length || nums[left] != target)
            return new int[] {-1, -1};
        return new int[] {left, searchFirst(nums, target + 1) - 1};
    }
    public int searchFirst(int[] nums, int target) {
        int left = 0, right = nums.length;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}

