/*剑指 Offer 53 - II. 0～n-1中缺失的数字

一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

示例 1:
输入: [0,1,3]
输出: 2

示例 2:
输入: [0,1,2,3,4,5,6,7,9]
输出: 8
*/

/*
解法：二分法。left = 0，right = len - 1。如果mid == nums[mid]，说明target在右侧，即left = mid + 1；若不等，则target在左侧。right = mid - 1.
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.7 MB, 在所有 Java 提交中击败了98.87% 的用户
*/
class Solution {
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) >> 1;
            if(nums[mid] == mid)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
}


