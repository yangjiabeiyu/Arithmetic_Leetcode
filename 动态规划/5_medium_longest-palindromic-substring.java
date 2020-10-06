/*
最长回文子串
https://leetcode-cn.com/problems/longest-palindromic-substring/
题目描述
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
示例
输入: "babad"   输出: "bab"
注意: "aba" 也是一个有效答案。
*/

/*
解法一：动态规划，p[i][j] = p[i+1][j-1] && s[i] == s[j]；对于初始值，如果i = j，则p[i][j] = true;如果i == j-1，则p[i][j] = s[i] == s[j]
注意：在状态转移方程中，我们是从长度较短的字符串向长度较长的字符串进行转移的，因此一定要注意动态规划的循环顺序。
执行用时：277 ms, 在所有 Java 提交中击败了10.53% 的用户
内存消耗：44.5 MB, 在所有 Java 提交中击败了5.78% 的用户
*/

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] res = new boolean[len][len];
        String ans = "";
        for(int k = 0; k < len; k++) {  //循环长度
            for(int i = 0; k + i < len; i++) {  //循环起始点
                int j = i + k;
                if(k == 0)
                    res[i][j] = true;
                else if(k == 1)
                    res[i][j] = s.charAt(i) == s.charAt(j);
                else
                    res[i][j] = res[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
                if(res[i][j] && ans.length() < k + 1)
                    ans = s.substring(i, j + 1);
            }
        }
        return ans;
    }
}

/*
解法二：遍历字符串，分别以每个字符为中心向两周扩展，找到最长的回文字串
*/
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len <= 1)
            return s;
        String ans = "";
        for(int k = 0; k < len; k++) {
            int len1 = expand(s, k, k);
            int len2 = expand(s, k, k + 1);
            int maxLen = Math.max(len1, len2);
            if(maxLen > ans.length())
                ans = s.substring(k - (maxLen - 1) / 2, k + maxLen / 2 + 1);
        }
        return ans;
    }
    public static int expand(String s, int start, int end) {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }
}
