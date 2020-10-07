/*
整数反转
https://leetcode-cn.com/problems/reverse-integer/
题目描述
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
示例
输入: 123   输出: 321
注意:
假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31, 2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
*/

/*
解法：
如果 temp = rev * 10 + pop 导致溢出，那么一定有 rev ≥ INTMAX / 10;
如果 rev > INTMAX / 10，那么 temp = rev * 10 + pop 一定会溢出；
如果 rev == INTMAX / 10，那么只要 pop > 7，temp = rev * 10 + pop 就会溢出。
当 rev 为负时可以应用类似的逻辑。
执行用时：2 ms, 在所有 Java 提交中击败了35.54% 的用户
内存消耗：35.9 MB, 在所有 Java 提交中击败了90.20% 的用户
*/

class Solution {
    public int reverse(int x) {
        int res = 0;
        while(x != 0) {
            int mod = x % 10;
            x /= 10;
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && mod > Integer.MAX_VALUE % 10))
                return 0;
            if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && mod < Integer.MIN_VALUE % 10))
                return 0;
            res = res * 10 + mod;
        }
        return res;
    }
}
