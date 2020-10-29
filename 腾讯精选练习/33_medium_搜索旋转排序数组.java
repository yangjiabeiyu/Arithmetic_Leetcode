/*
33. 搜索旋转排序数组
https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
给你一个升序排列的整数数组 nums ，和一个整数 target 。
假设按照升序排序的数组在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

示例 1：
输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4

示例 2：
输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1

示例 3：
输入：nums = [1], target = 0
输出：-1

提示：
    1 <= nums.length <= 5000
    -10^4 <= nums[i] <= 10^4
    nums 中的每个值都 独一无二
    nums 肯定会在某个点上旋转
    -10^4 <= target <= 10^4
*/

/*
方法一：递归，但是太笨了，复杂度也是O(n)
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：37.8 MB, 在所有 Java 提交中击败了91.09% 的用户
*/
class Solution {
    public int res = -1;
    public int search(int[] nums, int target) {
        search(nums, target, 0, nums.length - 1);
        return res;
    }
    public void search(int[] nums, int target, int left, int right) {
        if(left > right)
            return;
        int mid = (left + right) / 2;
        if(nums[mid] == target) {
            res = mid;
            return;
        }
        search(nums, target, left, mid - 1);
        search(nums, target, mid + 1, right);
    }
}

/*
解法二：问题的关键在于，只是简单比较target与mid处的值是无法缩小区间的；可以使用left或者right进行辅助。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：37.8 MB, 在所有 Java 提交中击败了92.96% 的用户
*/
class Solution {
    public int res = -1;
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] >= nums[0]) {        // 如果mid在左侧增区间
                if(target >= nums[0] && target < nums[mid])       // 而且target在[0, mid-1],那么就只需要在左侧区间查找；否则taget在右侧区间
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            else {                            // 如果mid在右侧增区间
                if(target <= nums[nums.length - 1] && target > nums[mid])  // 而且target在[mid+1, n-1],那么就只需要在右侧区间查找；否则taget在左侧区间
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
}


