/*
剑指 Offer 16. 数值的整数次方
https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。

示例 1:
输入: 2.00000, 10
输出: 1024.00000

示例 2:
输入: 2.10000, 3
输出: 9.26100

示例 3:
输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25

说明:
    -100.0 < x < 100.0
    n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
*/

/*
解法：快速幂运算，x^10 * res = (x^2)^5 * res = (x^2)^4 *(res*x^2) = (x^4)^2 *(res*x^2) = (x^8)^1 *(res*x^2) = (x^8)^0 *(res*x^2*x^8);
执行用时：1 ms, 在所有 Java 提交中击败了95.87% 的用户
内存消耗：36.6 MB, 在所有 Java 提交中击败了34.85% 的用户
*/
class Solution {
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        long b = n;   // 这里是为了防止越界，n最小可达到-2^31，直接取反会越界
        if(b < 0) {
            b = -b;
            x = 1.0 / x;
        }
        double res = 1.0;
        while(b > 0) {
            if(b % 2 == 1)
                res *= x;
            x *= x;
            b /= 2;
        }
        return res;
    }
}


