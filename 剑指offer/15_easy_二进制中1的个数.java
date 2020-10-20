/*
剑指 Offer 15. 二进制中1的个数
请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。

示例 1：

输入：00000000000000000000000000001011
输出：3
解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
解法一：不断移位
执行用时：1 ms, 在所有 Java 提交中击败了99.47% 的用户
内存消耗：35.5 MB, 在所有 Java 提交中击败了91.97% 的用户
*/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res += n & 1;
            n >>>= 1;
        }
        return res;
    }
}

/*
解法二：使用n&(n-1)，对于从后往前的第一个1，n-1则是该位变成0，后面全是1，所以n&(n-1)使得包括该位，后面的也都为0，一直迭代到n为0
执行用时：1 ms, 在所有 Java 提交中击败了99.47% 的用户
内存消耗：34.9 MB, 在所有 Java 提交中击败了99.85% 的用户
*/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }
}

