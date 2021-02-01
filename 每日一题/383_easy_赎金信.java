/*
383. 赎金信
给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
https://leetcode-cn.com/problems/ransom-note/
(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)

注意：
你可以假设两个字符串均只含有小写字母。
canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/

/*
解法一：用hashmap计数
执行用时：13 ms, 在所有 Java 提交中击败了26.82%的用户
内存消耗：39.1 MB, 在所有 Java 提交中击败了20.19%的用户
*/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            if(!map.containsKey(ch) || map.get(ch) == 0)
                return false;
            else map.put(ch, map.getOrDefault(ch, 0) - 1);
        }
        return true;
    }
}

/*
解法二：考虑到字符仅有a～z，所以可以用数组来代替hashmap
执行用时：6 ms, 在所有 Java 提交中击败了37.78%的用户
内存消耗：38.6 MB, 在所有 Java 提交中击败了77.43%的用户
*/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cnt = new int[26];
        for(int i = 0; i < magazine.length(); i++)
            cnt[magazine.charAt(i) - 'a']++;
        for(int i = 0; i < ransomNote.length(); i++) {
            int pos = ransomNote.charAt(i) - 'a';
            if(cnt[pos] == 0) return false;
            cnt[pos]--;
        }
        return true;
    }
}

