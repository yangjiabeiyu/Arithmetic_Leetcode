/*
205. 同构字符串
https://leetcode-cn.com/problems/isomorphic-strings/
给定两个字符串 s 和 t，判断它们是否是同构的。
如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

示例 1:
输入: s = "egg", t = "add"
输出: true

示例 2:
输入: s = "foo", t = "bar"
输出: false

示例 3:
输入: s = "paper", t = "title"
输出: true
*/

/*
解法：双哈希表
执行用时：21 ms, 在所有 Java 提交中击败了15.46% 的用户
内存消耗：38.6 MB, 在所有 Java 提交中击败了81.58% 的用户
*/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i), ch2 = t.charAt(i);
            if(map1.containsKey(ch1) && map2.containsKey(ch2)) {
                if(ch2 != map1.get(ch1) || ch1 != map2.get(ch2))
                    return false;
            }
            else if(!map1.containsKey(ch1) && !map2.containsKey(ch2)) {
                map1.put(ch1, ch2);
                map2.put(ch2, ch1);
            }
            else return false;
        }
        return true;
    }
}

/*
解法二：记录每个字符首次出现的位置，如果两个对应相等，那么就ok
执行用时：14 ms, 在所有 Java 提交中击败了38.01% 的用户
内存消耗：38.8 MB, 在所有 Java 提交中击败了61.25% 的用户
*/
class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i = s.length() - 1; i >= 0; i--) {
            map1.put(s.charAt(i), i);
            map2.put(t.charAt(i), i);
        }
        for(int i = 0; i < s.length(); i++)
            if(map1.get(s.charAt(i)) != map2.get(t.charAt(i)))
                return false;
        return true;
    }
}


