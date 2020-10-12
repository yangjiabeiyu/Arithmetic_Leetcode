/*
最长连续序列
https://leetcode-cn.com/problems/longest-consecutive-sequence/
给定一个未排序的整数数组，找出最长连续序列的长度。
要求算法的时间复杂度为 O(n)。
示例
输入: [100, 4, 200, 1, 3, 2]    输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
*/

/*
解法：动态规划，使用hashmap存储以nums[i]为端点的最长连续序列长度，则只需要找map中是否有nums[i]±1是否在map中，如果有就加上。
执行用时：9 ms, 在所有 Java 提交中击败了23.86% 的用户
内存消耗：39.5 MB, 在所有 Java 提交中击败了25.14% 的用户
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                int left = map.containsKey(nums[i] - 1) ? map.get(nums[i] - 1) : 0;   // 左侧存在就返回值，不存在则是0
                int right = map.containsKey(nums[i] + 1) ? map.get(nums[i] + 1) : 0;  // 右侧同左侧
                int num = left + right + 1;   // 计算当前的最大长度
                res = Math.max(res, num);     // 更新最大值
                map.put(nums[i], num);    // 放入map中
                map.put(nums[i] - left, num);    // 左右端点也需要更新最新值
                map.put(nums[i] + right, num);
            }
        }
        return res;
    }
}
