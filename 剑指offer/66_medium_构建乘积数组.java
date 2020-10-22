/*
剑指 Offer 66. 构建乘积数组

给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。

示例:
输入: [1,2,3,4,5]
输出: [120,60,40,30,24]
*/

/*
解法：先从左到右保存左乘积，然后从右到左保存乘积。
执行用时：2 ms, 在所有 Java 提交中击败了84.13% 的用户
内存消耗：51 MB, 在所有 Java 提交中击败了89.58% 的用户
*/

class Solution {
    public int[] constructArr(int[] a) {
        int n = a.length;
        if(n == 0)
            return new int[0];
        int[] b = new int[n];
        b[0] = 1;
        for(int i = 1; i < n; i++)
            b[i] = b[i - 1] * a[i - 1];
        int temp = 1;
        for(int i = n - 2; i >= 0; i--) {
            temp *= a[i + 1];
            b[i] *= temp;
        }
        return b;
    }
}

