/*
剑指 Offer 17. 打印从1到最大的n位数
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
示例 1:
输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]

说明：
    用返回一个整数列表来代替打印
    n 为正整数

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
解法一：若按照不会溢出来做，非常简单。
执行用时：1 ms, 在所有 Java 提交中击败了99.98% 的用户
内存消耗：46.4 MB, 在所有 Java 提交中击败了90.92% 的用户
*/
class Solution {
    public int[] printNumbers(int n) {
        int[] res = new int[(int)Math.pow(10, n) - 1];
        for(int i = 0; i < res.length; i++)
            res[i] = i + 1;
        return res;
    }
}

/*
解法二：按大数处理，原题是要打印，所以存在溢出的可能性

*/


