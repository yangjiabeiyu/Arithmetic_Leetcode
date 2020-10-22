/*
剑指 Offer 61. 扑克牌中的顺子

从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

示例 1:
输入: [1,2,3,4,5]
输出: True

示例 2:
输入: [0,0,1,2,5]
输出: True

限制：
数组长度为 5 
数组的数取值为 [0, 13] .
*/

/*
解法一：统计0的个数n0，同时统计非0的不重复的个数n1，记录其余的最大最小值，如果最大值-最小值<5，并且n0+n1==5，就说明是顺子
执行用时：1 ms, 在所有 Java 提交中击败了91.53% 的用户
内存消耗：35.8 MB, 在所有 Java 提交中击败了96.36% 的用户
*/
class Solution {
    public boolean isStraight(int[] nums) {
        int num0 = 0, num1 = 0, minVal = 13, maxVal = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++)
            if(nums[i] == 0)
                num0++;
            else if(set.add(nums[i])) {
                num1++;
                minVal = Math.min(minVal, nums[i]);
                maxVal = Math.max(maxVal, nums[i]);
            }
        if(maxVal - minVal < 5 && num0 + num1 == 5)
            return true;
        return false;
    }
}

/*
解法二：其实也不用统计0的个数，亦或者非零重复的个数，只需要判断非0的数字是否有重复，以及最大最小差值是否小于5即可。如果有重复，必不是顺子；极值大于4，也不可能。
执行用时：1 ms, 在所有 Java 提交中击败了91.53% 的用户
内存消耗：35.9 MB, 在所有 Java 提交中击败了95.21% 的用户
*/
class Solution {
    public boolean isStraight(int[] nums) {
        int minVal = 13, maxVal = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0 )
                continue;
            if(!set.add(nums[i]))
                return false;
            minVal = Math.min(minVal, nums[i]);
            maxVal = Math.max(maxVal, nums[i]);
        }
        return maxVal - minVal < 5;
    }
}

