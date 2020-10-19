/*
盛最多水的容器
https://leetcode-cn.com/problems/container-with-most-water/
给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
说明：你不能倾斜容器，且 n 的值至少为 2。
示例：
输入：[1,8,6,2,5,4,8,3,7]
输出：49
*/

/*
解法：双指针，初始位置在两端，然后高度较低者向里面走；因为若短板不动，长板移动，那么结果必然是要降低的。
执行用时：4 ms, 在所有 Java 提交中击败了68.17% 的用户
内存消耗：39.8 MB, 在所有 Java 提交中击败了14.50% 的用户
*/
class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        for(int i = 0, j = height.length - 1; i < j;)
            res = height[i] >= height[j] ? Math.max(res, (j - i) * height[j--]) : Math.max(res, (j - i) * height[i++]);
        return res;
    }
}

