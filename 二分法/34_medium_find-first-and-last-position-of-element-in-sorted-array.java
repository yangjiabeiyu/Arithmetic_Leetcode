/*
在排序数组中查找元素的第一个和最后一个位置
https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
题目描述
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
你的算法时间复杂度必须是 O(log n) 级别。
如果数组中不存在目标值，返回 [-1, -1]。
示例
输入: nums = [5,7,7,8,8,10], target = 8    输出: [3,4]
*/

/*
解法：二分法，找第一个≥target的元素位置，再找第一个≥target+1的元素位置
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：41.6 MB, 在所有 Java 提交中击败了99.25% 的用户
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = searchFirstPos(nums, target), right = searchFirstPos(nums, target + 1);
        if(left == nums.length || nums[left] != target)   // 如果到了nums.length或者返回的下标处的元素不是target，说明不存在target
            return new int[]{-1, -1};
        return new int[]{left, right - 1};
    }
    public int searchFirstPos(int[] nums, int target) {
        int left = 0, right = nums.length;   // 这里right需要是nums.length，而不能是nums.length-1。如果是后者，那么恰好target是最后一个，那么target+1也是最后一个，这就无法区分是否存在了
        while(left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
