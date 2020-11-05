/*
219. 存在重复元素 II
https://leetcode-cn.com/problems/contains-duplicate-ii/
给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。

示例 1:
输入: nums = [1,2,3,1], k = 3
输出: true

示例 2:
输入: nums = [1,0,1,1], k = 1
输出: true

示例 3:
输入: nums = [1,2,3,1,2,3], k = 2
输出: false
*/

/*
解法：hash表存储元素值及其下标，及时更新
执行用时：8 ms, 在所有 Java 提交中击败了97.23% 的用户
内存消耗：44.3 MB, 在所有 Java 提交中击败了32.05% 的用户
*/
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k)
                return true;
            map.put(nums[i], i); 
        }
        return false;
    }
}

