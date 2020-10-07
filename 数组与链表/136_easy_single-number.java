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
内存消耗：40 MB, 在所有 Java 提交中击败了21.98% 的用户
*/
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
            map.put(nums[i], map.containsKey(nums[i]));
        for(int i : map.keySet())
            if(!map.get(i))
                return i;
        return 0;
    }
}

/*
解法二：使用异或，n异或n = 0，n异或0 = n，且异或满足交换律
执行用时：1 ms, 在所有 Java 提交中击败了99.77% 的用户
内存消耗：38.9 MB, 在所有 Java 提交中击败了98.41% 的用户
*/
class Solution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
