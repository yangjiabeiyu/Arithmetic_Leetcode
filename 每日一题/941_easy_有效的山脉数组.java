/*
941. 有效的山脉数组
https://leetcode-cn.com/problems/valid-mountain-array/
给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。

让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
    A.length >= 3
    在 0 < i < A.length - 1 条件下，存在 i 使得：
        A[0] < A[1] < ... A[i-1] < A[i]
        A[i] > A[i+1] > ... > A[A.length - 1]
*/

/*
执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：39.5 MB, 在所有 Java 提交中击败了64.39% 的用户
*/
class Solution {
    public boolean validMountainArray(int[] A) {
        // 双指针，首指针需要增，尾指针也需要增
        int left = 0, right = A.length - 1;
        while(left < right && A[left] < A[left + 1])
            left++;
        while(left < right && A[right] < A[right - 1])
            right--;
        return left != 0 && right != A.length - 1 && left == right;
    }
}

