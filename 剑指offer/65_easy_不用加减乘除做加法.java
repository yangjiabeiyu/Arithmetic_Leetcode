/*
剑指 Offer 65. 不用加减乘除做加法
写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。

示例:

输入: a = 1, b = 1
输出: 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
解法：进位p = a & b，无进位和q = a ^ b，因此可以将进位左移一位，这样a+b就转为了p<<1+q，不断循环直至p为0，那么q即是加和值。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35.1 MB, 在所有 Java 提交中击败了98.12% 的用户
*/
class Solution {
    public int add(int a, int b) {
        while(b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}

