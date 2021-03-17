/*
389. 找不同
https://leetcode-cn.com/problems/find-the-difference/
给定两个字符串 s 和 t，它们只包含小写字母。
字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
请找出在 t 中被添加的字母。

示例 1：
输入：s = "abcd", t = "abcde"
输出："e"
解释：'e' 是那个被添加的字母。

示例 2：
输入：s = "", t = "y"
输出："y"
*/

/*
解法一：用char数组记录各字母出现的次数
执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：36.9 MB, 在所有 Java 提交中击败了36.87% 的用户
*/
class Solution {
    public char findTheDifference(String s, String t) {
        char[] cnt = new char[26], chs = s.toCharArray(), cht = t.toCharArray();
        for(char ch : chs)
            cnt[ch - 'a']++;
        for(char ch : cht) {
            if(cnt[ch - 'a']-- == 0)
                return ch;
        }
        return ' ';
    }
}

/*
解法二：加和，然后t的减去s的，就是多的那个，这个需要遍历所有
执行用时：3 ms, 在所有 Java 提交中击败了55.03% 的用户
内存消耗：36.9 MB, 在所有 Java 提交中击败了49.68% 的用户
*/
class Solution {
    public char findTheDifference(String s, String t) {
        char res = 0;
        for(int i = 0; i < t.length(); i++)
            res += t.charAt(i);
        for(int i = 0; i < s.length(); i++)
            res -= s.charAt(i);
        return res;
    }
}

/*
解法三：取异或
执行用时：3 ms, 在所有 Java 提交中击败了55.03% 的用户
内存消耗：36.8 MB, 在所有 Java 提交中击败了73.42% 的用户
*/
class Solution {
    public char findTheDifference(String s, String t) {
        char res = 0;
        for(int i = 0; i < t.length(); i++)
            res ^= t.charAt(i);
        for(int i = 0; i < s.length(); i++)
            res ^= s.charAt(i);
        return res;
    }
}

