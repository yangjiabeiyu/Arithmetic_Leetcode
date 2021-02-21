/*
229. 求众数 II
https://leetcode-cn.com/problems/majority-element-ii/
给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。

示例 1：
输入：[3,2,3]
输出：[3]

示例 2：
输入：nums = [1]
输出：[1]

示例 3：
输入：[1,1,1,3,3,2,2,2]
输出：[1,2]
*/

/*
解法：摩尔投票的进阶版，主要是考虑存储两个值，然后进行比较，最后也需要验证到底是不是大于n/3。
执行用时：2 ms, 在所有 Java 提交中击败了96.94% 的用户
内存消耗：42.5 MB, 在所有 Java 提交中击败了26.55% 的用户
*/
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int num1 = nums[0], num2 = nums[0], cnt1 = 0, cnt2 = 0;
        for(int num : nums) {
            if(num == num1) {
                cnt1++;
                continue;
            }
            if(num == num2) {
                cnt2++;
                continue;
            }
            if(cnt1 == 0) {
                num1 = num;
                cnt1 = 1;
                continue;
            }
            if(cnt2 == 0) {
                num2 = num;
                cnt2 = 1;
                continue;
            }
            cnt1--;
            cnt2--;
        }
        cnt1 = 0;
        cnt2 = 0;
        for(int num : nums) {
            if(num == num1) cnt1++;
            else if(num == num2) cnt2++;
        }
        if(cnt1 > nums.length / 3) res.add(num1);
        if(cnt2 > nums.length / 3) res.add(num2);
        return res;
    }
}

