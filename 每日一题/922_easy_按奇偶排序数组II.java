/*
922. 按奇偶排序数组 II
https://leetcode-cn.com/problems/sort-array-by-parity-ii/
给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
你可以返回任何满足上述条件的数组作为答案。

示例：
输入：[4,2,5,7]
输出：[4,5,2,7]
解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。

提示：
    2 <= A.length <= 20000
    A.length % 2 == 0
    0 <= A[i] <= 1000
*/

/*
解法：双指针
执行用时：3 ms, 在所有 Java 提交中击败了78.68% 的用户
内存消耗：39.7 MB, 在所有 Java 提交中击败了89.20% 的用户
*/
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0, j = 1, n = A.length;
        while(true) {
            while(i < n && A[i] % 2 == 0)
                i += 2;
            if(i >= n) return A;
            while(j < n && A[j] % 2 == 1)
                j += 2;
            swap(A, i ,j);
        }
    }
    public void swap(int[] A, int left, int right) {
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
    }
}

/*
双指针for循环
执行用时：3 ms, 在所有 Java 提交中击败了78.68% 的用户
内存消耗：39.7 MB, 在所有 Java 提交中击败了88.88% 的用户
*/
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for(int i = 0; i < A.length; i += 2) {
            if(A[i] % 2 == 1) {
                while(A[j] % 2 == 1)
                    j += 2;
                swap(A, i, j);
            }
        }
        return A;
    }
    public void swap(int[] A, int left, int right) {
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
    }
}

