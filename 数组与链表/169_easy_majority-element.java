/*
多数元素
https://leetcode-cn.com/problems/majority-element/
题目描述
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
你可以假设数组是非空的，并且给定的数组总是存在多数元素。
示例
输入: [3,2,3]    输出: 3
*/

/*
解法一：先排序，取中间值即可
执行用时：2 ms, 在所有 Java 提交中击败了77.20% 的用户
内存消耗：41.9 MB, 在所有 Java 提交中击败了90.80% 的用户
*/
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return(nums[nums.length >> 1]);
    }
}

/*
解法二：摩尔投票，遍历数组，设置候选众数为第一个元素，统计次数cnt，相同+1，不同-1；如果次数为0，则当前元素变为候选众数。
这里意思不是上一个候选众数一定不是众数，如果是众数，且cnt=0，这说明后面肯定还有机会"卷土重来"，因为在前面的数字中，它仅仅是占了不超过一半，后面的数字中，它必然占到一半以上。
执行用时：2 ms, 在所有 Java 提交中击败了77.20% 的用户
内存消耗：42 MB, 在所有 Java 提交中击败了76.72% 的用户
*/
class Solution {
    public int majorityElement(int[] nums) {
        int num = nums[0], cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            if(cnt == 0)
                num = nums[i];
            cnt += nums[i] == num ? 1 : -1;
        }
        return num;
    }
}
