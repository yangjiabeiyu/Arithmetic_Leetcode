/*
387. 字符串中的第一个唯一字符
https://leetcode-cn.com/problems/first-unique-character-in-a-string/
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

示例：
s = "leetcode"
返回 0
s = "loveleetcode"
返回 2

提示：你可以假定该字符串只包含小写字母。
*/

/*
解法：先用hash表存储次数，或者是否只出现1次；然后再遍历一次，如果次数为1就返回。
执行用时：24 ms, 在所有 Java 提交中击败了62.46% 的用户
内存消耗：38.9 MB, 在所有 Java 提交中击败了91.50% 的用户
*/
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Boolean> map = new HashMap<>();
        char[] chs = s.toCharArray();
        for(char ch : chs)
            map.put(ch, !map.containsKey(ch));
        for(int i = 0; i < chs.length; i++)
            if(map.get(chs[i]))
                return i;
        return -1;
    }
}

