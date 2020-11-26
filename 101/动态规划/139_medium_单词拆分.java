/*
139. 单词拆分
https://leetcode-cn.com/problems/word-break/
给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：
    拆分时可以重复使用字典中的单词。
    你可以假设字典中没有重复的单词。

示例 1：
输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。

示例 2：
输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。
*/

/*
解法一：动态规划，遍历列表，然后看是否有匹配的单词
执行用时：3 ms, 在所有 Java 提交中击败了89.18% 的用户
内存消耗：38.3 MB, 在所有 Java 提交中击败了83.07% 的用户
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        if(n == 0)
            return true;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i = 1; i <= n; i++) {
            for(String word : wordDict) {
                int len = word.length();
                if(i >= len && dp[i - len] && s.substring(i - len, i).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}

/*
解法二：动态规划，将列表转为hashset，遍历以当前字符结尾的字串，看是否存在于set中
执行用时：4 ms, 在所有 Java 提交中击败了85.56% 的用户
内存消耗：38.3 MB, 在所有 Java 提交中击败了82.96% 的用户
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i = 1; i <= n; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}

