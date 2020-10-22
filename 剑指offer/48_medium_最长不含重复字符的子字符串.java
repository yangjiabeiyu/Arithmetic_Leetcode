/*
剑指 Offer 48. 最长不含重复字符的子字符串

请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

示例 1:
输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
*/

/*
解法：遍历字符串，计算以当前字符结束的最长不重复字串长度；主要是需要对起始位置进行更新，如果当前字符之前出现过，就需要看是否在起始位置右边，在左边就无所谓了。
执行用时：7 ms, 在所有 Java 提交中击败了84.50% 的用户
内存消耗：38.3 MB, 在所有 Java 提交中击败了97.88% 的用户
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int prePos = 0, res = 0, start = 0;
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i)))
                start = Math.max(map.get(s.charAt(i)) + 1, start);      // 更新起始位置
            res = Math.max(res, i - start + 1);
            map.put(s.charAt(i), i);
        }
        return res;
    }
}

