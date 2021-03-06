/*
合并两个有序数组
https://leetcode-cn.com/problems/merge-sorted-array/
题目描述
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
说明
初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例
输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3
输出: [1,2,2,3,5,6]
*/

/*
解法：从后往前放置较大的数字
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：39.1 MB, 在所有 Java 提交中击败了22.26% 的用户
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while(k >= 0) {
            if(i < 0 || j < 0)
                nums1[k--] = i < 0 ? nums2[j--] : nums1[i--];
            else
                nums1[k--] = nums1[i] <= nums2[j] ? nums2[j--] : nums1[i--];
        }
    }
}
