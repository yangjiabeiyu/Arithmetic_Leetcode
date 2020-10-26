/*
剑指 Offer 44. 数字序列中某一位的数字
https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
请写一个函数，求任意第n位对应的数字。

示例 1：
输入：n = 3
输出：3

示例 2：
输入：n = 11
输出：0
*/

/*
解法：对于1~9，共9*1个字符；10~99，共90*2个字符；100~999，共900*3个字符；对于10^n~10^(n+1)-1，共9*(10^n)*(n+1)个字符。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：34.9 MB, 在所有 Java 提交中击败了99.45% 的用户
*/
class Solution {
    public int findNthDigit(int n) {
        int digit = 1;      // 记录位数，从1~9开始考虑，0的话可以另作讨论，但后续其实不用讨论
        long start = 1, count = 9;     // 起始的开始值为1，总位数为9
        while(n > count) {     // 如果n不在当前的数字段
            n -= count;
            digit++;  // 增加位数
            start *= 10;   // 起始数*10
            count = 9 * start * digit;   // 该数字段的总字符数
        }
        long num = start + (n - 1) / digit;   // 找到具体是哪个数字
        return Long.toString(num).charAt((n-1) % digit) - '0';    // 找到是数字的哪个字符
    }
}

