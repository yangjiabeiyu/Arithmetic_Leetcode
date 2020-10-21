/*
剑指 Offer 53 - I. 在排序数组中查找数字 I

统计一个数字在排序数组中出现的次数。

示例 1:
输入: nums = [5,7,7,8,8,10], target = 8
输出: 2

示例 2:
输入: nums = [5,7,7,8,8,10], target = 6
输出: 0
*/

/*
解法：找target和target+1的左边界即可
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：41.2 MB, 在所有 Java 提交中击败了97.42% 的用户
*/
class Solution {
    public int search(int[] nums, int target) {
        return find(nums, target + 1) - find(nums, target);
    }
    public int find(int[] nums, int target) {
        int left = 0, right = nums.length;
        while(left < right) {
            int mid = (left + right) >> 1;
            if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}


/*
补充一个其他做法
作者：jyd
链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/solution/mian-shi-ti-53-i-zai-pai-xu-shu-zu-zhong-cha-zha-5/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }
    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}

