/*
剑指 Offer 46. 把数字翻译成字符串
https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

示例 1:
输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
*/

/*
解法：动态规划，如果当前字符和上个字符在10~25之间，那么dp[i] = dp[i-1]+dp[i-2]；否则dp[i] = dp[i-1]
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35 MB, 在所有 Java 提交中击败了98.16% 的用户
*/
class Solution {
    public int translateNum(int num) {
        String s = Integer.toString(num);    // 转为字符串
        int pre = 1, cur = 1;   // 对应于i-2与i-1
        for(int i = 1; i < s.length(); i++) {
            int temp = cur;       // 无论怎样，都会有dp[i-1]
            int res = 10 * (s.charAt(i - 1) - '0') + (s.charAt(i) - '0');  // 求出前后组成的数字大小
            if(res >= 10 && res <= 25)  // 如果在10和25之间，那么就需要加上dp[i-2]
                temp += pre;
            pre = cur;    // 更新
            cur = temp;
        }
        return cur;
    }
}

/*
可以有多种写法，如转为字符串使用的方法、求取前后组成数字的大小等
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35.1 MB, 在所有 Java 提交中击败了95.13% 的用户
*/
class Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int pre = 1, cur = 1;
        for(int i = 2; i <= s.length(); i++) {
            int temp = cur;
            String ch = s.substring(i - 2, i);
            if(ch.compareTo("10") >= 0 && ch.compareTo("25") <= 0)
                temp += pre;
            pre = cur;
            cur = temp;
        }
        return cur;
    }
}


