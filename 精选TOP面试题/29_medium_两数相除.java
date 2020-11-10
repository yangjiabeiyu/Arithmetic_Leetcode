/*
29. 两数相除
https://leetcode-cn.com/problems/divide-two-integers/
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
返回被除数 dividend 除以除数 divisor 得到的商。
整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

示例 1:
输入: dividend = 10, divisor = 3
输出: 3
解释: 10/3 = truncate(3.33333..) = truncate(3) = 3

示例 2:
输入: dividend = 7, divisor = -3
输出: -2
解释: 7/-3 = truncate(-2.33333..) = -2

提示：
    被除数和除数均为 32 位有符号整数。
    除数不为 0。
    假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
*/

/*
解法：详见代码，主要就是逐个加或者减，效率慢；可以每次翻倍来快速逼近被除数，相应的结果也每次翻倍。
执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35.4 MB, 在所有 Java 提交中击败了93.36% 的用户
*/
class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1)    // 越界的情况
            return Integer.MAX_VALUE;
        if(divisor == 1) return dividend;      // 一些特殊情况
        if(divisor == -1) return -dividend;
        if(dividend == 0) return 0;
        int flag = 1;   // 判断正负号
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            flag = -1;
        divisor = divisor > 0 ? -divisor : divisor;   // 都转为负数，因为其范围更大
        dividend = dividend > 0 ? -dividend :dividend;
        return flag == 1 ? div(dividend, divisor) : -div(dividend, divisor);
    }
    public int div(int dividend, int divisor) {  // 注意两个数字都是负数
        if(dividend > divisor) return 0;
        int count = 1, p = dividend, q = divisor;
        while(q > p - q) {         // 注意这里的表达方式，如果写为q + q > p，可能会出现越界问题；每次翻倍更快逼近被除数
            count += count;
            q += q;
        }
        return count + div(p - q, divisor);
    }
}

