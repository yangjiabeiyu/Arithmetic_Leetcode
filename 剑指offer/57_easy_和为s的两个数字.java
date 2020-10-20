/*
剑指 Offer 57. 和为s的两个数字
输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。

示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[2,7] 或者 [7,2]

示例 2：

输入：nums = [10,26,30,31,47,60], target = 40
输出：[10,30] 或者 [30,10]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
解法一：类比三数之和，设置一个尾指针
执行用时：3 ms, 在所有 Java 提交中击败了34.58% 的用户
内存消耗：55.1 MB, 在所有 Java 提交中击败了97.01% 的用户
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int j = nums.length - 1;
        for(int i = 0; i < nums.length; i++) {
            while(j > i && nums[j] + nums[i] > target)
                j--;
            if(j == i)
                break;
            if(nums[i] + nums[j] == target)
                return new int[] {nums[i], nums[j]};
        }
        return new int[0];
    }
}

/*
解法二：思路相似，但是如果从双指针的角度来看，可以看作一个对撞指针，一个在首，一个在尾。如果两个值加和大于target，把尾指针前移；小于则首指针后移。
执行用时：2 ms, 在所有 Java 提交中击败了98.57% 的用户
内存消耗：55 MB, 在所有 Java 提交中击败了97.73% 的用户
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while(i < j) {
            if(nums[j] + nums[i] < target)
                i++;
            else if(nums[i] + nums[j] > target)
                j--;
            else
                return new int[] {nums[i], nums[j]};
        }
        return new int[0];
    }
}


