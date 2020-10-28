/*
217. 存在重复元素
https://leetcode-cn.com/problems/contains-duplicate/
给定一个整数数组，判断是否存在重复元素。

如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。

示例 1:
输入: [1,2,3,1]
输出: true

示例 2:
输入: [1,2,3,4]
输出: false

示例 3:
输入: [1,1,1,3,3,4,3,2,4,2]
输出: true
*/

/*
解法：hashset
执行用时：5 ms, 在所有 Java 提交中击败了76.75% 的用户
内存消耗：42.2 MB, 在所有 Java 提交中击败了95.27% 的用户
*/
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++)
            if(!set.add(nums[i]))
                return true;
        return false;
    }
}


