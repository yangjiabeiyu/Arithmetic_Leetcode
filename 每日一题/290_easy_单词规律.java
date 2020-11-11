/*
290. 单词规律
https://leetcode-cn.com/problems/word-pattern/
给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

示例1:
输入: pattern = "abba", str = "dog cat cat dog"
输出: true

示例 2:
输入:pattern = "abba", str = "dog cat cat fish"
输出: false

示例 3:
输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false

示例 4:
输入: pattern = "abba", str = "dog dog dog dog"
输出: false

说明:
你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。    
*/

/*
解法：本题主要是11对应，所以可以用两个hashmap
执行用时：1 ms, 在所有 Java 提交中击败了98.65% 的用户
内存消耗：36.1 MB, 在所有 Java 提交中击败了98.89% 的用户
*/
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strs = s.split(" ");
        if(pattern.length() != strs.length) return false;
        Map<String, Character> map1 = new HashMap<>();
        Map<Character, String> map2 = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char ch = pattern.charAt(i);
            if(!map1.containsKey(strs[i]) && !map2.containsKey(ch)) {    // 两个表都没有，就存进去
                map1.put(strs[i], ch);
                map2.put(ch, strs[i]);
            }
            else if(map1.containsKey(strs[i]) && map2.containsKey(ch)) {   // 两个表都有，看看对应关系是否相同
                if(!map1.get(strs[i]).equals(ch) || !map2.get(ch).equals(strs[i]))
                    return false;
            }
            else return false;   // 一个表有，一个表没有，就false
        } 
        return true;
    }
}


