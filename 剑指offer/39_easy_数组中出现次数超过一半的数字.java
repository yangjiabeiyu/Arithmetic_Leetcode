/*
剑指 Offer 39. 数组中出现次数超过一半的数字

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例 1:
输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2
*/

/*
解法一：摩尔投票
执行用时：2 ms, 在所有 Java 提交中击败了71.91% 的用户
内存消耗：41.4 MB, 在所有 Java 提交中击败了99.54% 的用户
*/
class Solution {
    public int majorityElement(int[] nums) {
        int condi = nums[0], cnt = 0;
        for(int num : nums) {
            if(cnt == 0) 
                condi = num;
            cnt += num == condi ? 1 : -1;
        }
        return condi;
    }
}


/*
解法二：排序，中间数即是目标值
执行用时：2 ms, 在所有 Java 提交中击败了71.91% 的用户
内存消耗：41.2 MB, 在所有 Java 提交中击败了99.87% 的用户
*/
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }
}

