/*
140. 单词拆分 II
https://leetcode-cn.com/problems/word-break-ii/
给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。

说明：
    分隔时可以重复使用字典中的单词。
    你可以假设字典中没有重复的单词。

示例 1：
输入:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
输出:
[
  "cats and dog",
  "cat sand dog"
]

示例 2：
输入:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
输出:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
解释: 注意你可以重复使用字典中的单词。
*/

/*
解法：先判断是否有解，降低复杂度，然后再回溯得到所有解。
执行用时：7 ms, 在所有 Java 提交中击败了84.37% 的用户
内存消耗：38.8 MB, 在所有 Java 提交中击败了91.15% 的用户
*/
class Solution {
    List<String> path = new ArrayList<>();
    List<String> res = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>();
        for(String str : wordDict)  // 把单词放入hash表
            words.add(str);
        // 先判断是否能构成目标字符串
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int right = 1; right <= s.length(); right++) {
            for(int left = right - 1; left >= 0; left--) {     // 对于单词长度较短时，从右到左比对比较好，相当于比较的字符串一开始长度小
                if(words.contains(s.substring(left, right)) && dp[left]) {   // 如果left已经ok，子串也在，那就为true
                    dp[right] = true;
                    break;
                }
            }
        }
        if(dp[s.length()]) // 如果有解，就开始回溯
            dfs(s, words, 0);
        return res;
    }
    public void dfs(String s, Set<String> words, int start) {
        if(start == s.length()) {
            res.add(String.join(" ", path));  // 该方法用于拼接字符串数组或队列；如果hold不住，可以用List<List<String>>存储结果，然后再主函数逐个循环拼接
            return;
        }
        for(int i = start + 1; i <= s.length(); i++) {
            if(words.contains(s.substring(start, i))) {  // 如果存在，就继续
                path.add(s.substring(start, i));
                dfs(s, words, i);
                path.remove(path.size() - 1);  // 回溯
            }
        }
        
    }
}

