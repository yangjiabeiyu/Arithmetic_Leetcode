/*
移除元素
https://leetcode-cn.com/problems/remove-element/submissions/
题目描述
给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
示例
给定 nums = [3,2,2,3], val = 3,
函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
*/

/*
解法一：双指针，指针一从头开始，指针二从尾开始，如果指针一指向的数值与val相同，那么就把指针二对应的元素给到指针一，并前移。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：37.2 MB, 在所有 Java 提交中击败了81.93% 的用户
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int n1 = 0, n2 = nums.length - 1;
        while(n1 <= n2) {
            if(nums[n1] != val)
                n1++;
            else
                nums[n1] = nums[n2--];
        }
        return n1;
    }
}

/*
解法二：双指针，都从头部开始，当指针一指向的数值与val不同，那么就将指针二前移；否则，指针二不动。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：37.2 MB, 在所有 Java 提交中击败了77.77% 的用户
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val)
                nums[j++] = nums[i];
        }
        return j;
    }
}
