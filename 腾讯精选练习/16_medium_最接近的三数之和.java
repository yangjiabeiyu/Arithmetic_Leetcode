/*
16. 最接近的三数之和
https://leetcode-cn.com/problems/3sum-closest/
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

示例:
输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

提示：
    3 <= nums.length <= 10^3
    -10^3 <= nums[i] <= 10^3
    -10^4 <= target <= 10^4
*/

/*
解法：类似于三数之和，对于二重循环，分别设置起始位与结束位，如果sum更大，就让结束位前移；较小，就让起始位后移；相等，直接返回target
执行用时：6 ms, 在所有 Java 提交中击败了84.89% 的用户
内存消耗：38.2 MB, 在所有 Java 提交中击败了86.13% 的用户
*/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];   // 设置初始的res
        for(int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;  // 设置起始位与终止位
            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(Math.abs(sum - target) < Math.abs(res - target))   // 更新res
                    res = sum;
                if(target < sum)
                    end--;
                else if(target > sum)
                    start++;
                else
                    return target;
            }
        }
        return res;
    }
}


