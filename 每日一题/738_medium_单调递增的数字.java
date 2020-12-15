/*
738. 单调递增的数字
https://leetcode-cn.com/problems/monotone-increasing-digits/
给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
（当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）

示例 1:
输入: N = 10
输出: 9

示例 2:
输入: N = 1234
输出: 1234

示例 3:
输入: N = 332
输出: 299

说明: N 是在 [0, 10^9] 范围内的一个整数。
*/

/*
解法：可以从后往前找，遇到左边大的情况，左边减1，记录右边的位置；循环停止后，把记录位置及后面的都置为9；
也可以从前往后找，遇到左边大的情况，把左边减1；然后向左找（例如332，第二个3变成2后，又比第一个3小了，所以还要往左看），最后将停止位置后面的置为9；
也可以从前往后找到第一个左边大的情况后，先将后面的数字都置为9；然后往左找，左边大则减1，同时将右边的置为9。
执行用时：1 ms, 在所有 Java 提交中击败了97.96% 的用户
内存消耗：35.2 MB, 在所有 Java 提交中击败了86.63% 的用户
*/
class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] chs = String.valueOf(N).toCharArray();
        for(int i = 0; i < chs.length - 1; ++i) {
            if(chs[i] > chs[i + 1]) {  // 一旦找到左边大的就不需要再往右找了，因为都要置为9
                chs[i] -= 1;   // 左边数字减1
                for(int j = i + 1; j < chs.length; j++)  // 右边的都置为9
                    chs[j] = '9';
                for(int j = i; j > 0; --j)   // 往左边找
                    if(chs[j] < chs[j - 1]) {  // 如果左边大，就左边数字减1，右边数字置为9
                        chs[j - 1] -= 1;
                        chs[j] = '9';
                    }
                    else break;
                break;
            }
        }
        return Integer.parseInt(String.valueOf(chs));
    }
}

