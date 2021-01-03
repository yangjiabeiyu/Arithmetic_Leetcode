/*
80. 删除排序数组中的重复项 II
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
*/

/*
解法：双指针，但我的方法比较笨……
执行用时：1 ms, 在所有 Java 提交中击败了83.48% 的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了76.53% 的用户
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int cur = nums[0] - 1, cnt = 0, i = 0;  // cur就是当前的数值，cnt记录出现的次数，i记录新数组长度
        for(int j = 0; j < nums.length;) {
            if(cur == nums[j]) {   // 如果遍历值和当前值一样，就看次数有了几次
                if(cnt < 2) {  // 如果才1次，就cnt++，然后覆盖值
                    cnt++;
                    nums[i++] = nums[j++];
                }
                else  // 否则，不覆盖
                    j++;
            }
            else {  // 如果不相等，就重置cnt和当前值，并且覆盖
                cnt = 1;
                cur = nums[j];
                nums[i++] = nums[j++];
            }
        }
        return i;
    }
}

/*
更简洁的方法
执行用时：1 ms, 在所有 Java 提交中击败了83.48% 的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了75.42% 的用户
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt = 1, i = 1;
        for(int j = 1; j < nums.length; j++) {
            if(nums[j] == nums[j - 1])
                cnt++;
            else
                cnt = 1;
            if(cnt <= 2)
                nums[i++] = nums[j];
        }
        return i;
    }
}

