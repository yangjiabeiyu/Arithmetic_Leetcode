/*
回文子串
https://leetcode-cn.com/problems/palindromic-substrings/
题目描述
给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
示例
输入："aaa"    输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
*/

/*
解法：中心扩展法，遍历加和；也可以动态规划，然后计算true的个数
执行用时：4 ms, 在所有 Java 提交中击败了82.76% 的用户
内存消耗：36.8 MB, 在所有 Java 提交中击败了86.01% 的用户
*/

class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++)
            res += fun(s, i, i) + fun(s, i, i + 1);
        return res;
    }
    public int fun(String s, int left, int right) {
        int cnt = 0;
        while(left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++))
            cnt++;
        return cnt;
    }
}
