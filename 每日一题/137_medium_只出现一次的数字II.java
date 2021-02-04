/*
137. 只出现一次的数字 II
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
https://leetcode-cn.com/problems/single-number-ii/
说明：
你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
示例 1:
输入: [2,2,3,2]
输出: 3
示例 2:
输入: [0,1,0,1,0,1,99]
输出: 99
*/

/*
解法：统计各位的出现次数，对3取余就是剩下那个数字
执行用时：2 ms, 在所有 Java 提交中击败了68.69%的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了16.29%的用户
*/
class Solution {
    public int singleNumber(int[] nums) {
        int[] countNum = new int[32];
        for(int num : nums) {
            for(int i = 0; i < 32; i++) {
                countNum[i] += num & 1;
                num = num >>> 1;
            }
        }
        int res = 0;
        for(int i = 31; i >= 0; i--) {
            res <<= 1;
            res += countNum[i] % 3;
        }
        return res;
    }
}

