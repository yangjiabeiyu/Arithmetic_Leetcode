/*
88. 合并两个有序数组
https://leetcode-cn.com/problems/merge-sorted-array/
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。

说明：
    初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
    你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

示例：
输入：
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3
输出：[1,2,2,3,5,6]
*/

/*
解法：尾部开始向前走
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.7 MB, 在所有 Java 提交中击败了55.31% 的用户
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

/*
解法二：这道题可以更为简化，一个是使用m和n代替i和j，另外一个，如果是nums2先到了0，就不用再对nums1赋值了，因为本身就在，所以只需要考虑nums1先遍历完的情形。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.7 MB, 在所有 Java 提交中击败了54.88% 的用户
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m-- + n-- - 1;
        while(m >= 0 && n >= 0)
            nums1[k--] = nums1[m] <= nums2[n] ? nums2[n--] : nums1[m--];
        while(n >= 0)
            nums1[k--] = nums2[n--];
    }
}

