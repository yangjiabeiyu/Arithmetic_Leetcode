/*
除自身以外数组的乘积
https://leetcode-cn.com/problems/product-of-array-except-self/
题目描述
给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
示例
输入: [1,2,3,4]    输出: [24,12,8,6]
提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
进阶：
你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
*/

/*
解法一：创建两个数组，一个保存从左到右的连乘结果，另外一个保存从右到左的连乘结果，最后对应相乘即可。
执行用时：2 ms, 在所有 Java 提交中击败了34.99% 的用户
内存消耗：48.3 MB, 在所有 Java 提交中击败了5.00% 的用户
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] reverse = new int[n];
        res[0] = 1;
        reverse[n - 1] = 1;
        for(int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
            reverse[n - i - 1] = nums[n - i] * reverse[n - i];
        }
        for(int i = 0; i < n; i++)
            res[i] = res[i] * reverse[i];
        return res;
    }
}

/*
解法二：创建一个数组，然后先正序存储连乘结果，在逆向时，只需要用一个数字来迭代存储结果即可。
执行用时：2 ms, 在所有 Java 提交中击败了34.99% 的用户
内存消耗：49.1 MB, 在所有 Java 提交中击败了5.00% 的用户
*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length, temp = 1;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1; i < n; i++)
            res[i] = res[i - 1] * nums[i - 1];
        for(int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * temp;
            temp *= nums[i];
        } 
        return res;
    }
}
