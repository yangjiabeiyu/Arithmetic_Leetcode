/*
只出现一次的数字
https://leetcode-cn.com/problems/single-number/
题目描述
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
示例
输入: [4,1,2,1,2]    输出: 4
*/

/*
解法一：使用额外空间，遍历数组，放入map中，对出现一次和出现两次的元素进行区分
执行用时：15 ms, 在所有 Java 提交中击败了7.18% 的用户
内存消耗：40.2 MB, 在所有 Java 提交中击败了5.26% 的用户
*/
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]))
                map.put(nums[i], true);
            else
                map.put(nums[i], false);
        }
        for(int i : map.keySet()) {
            if(!map.get(i))
                return i;
        }
        return 0;
    }
}

