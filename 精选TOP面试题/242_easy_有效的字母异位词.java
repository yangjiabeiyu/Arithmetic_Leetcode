/*
242. 有效的字母异位词
https://leetcode-cn.com/problems/valid-anagram/
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:
输入: s = "anagram", t = "nagaram"
输出: true

示例 2:
输入: s = "rat", t = "car"
输出: false

说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
*/

/*
解法一：遇到相同的继续；不同的先固定一个，下找另外一个，找到相同的，就交换；找不到就报错。
执行用时：34 ms, 在所有 Java 提交中击败了5.35% 的用户
内存消耗：38.8 MB, 在所有 Java 提交中击败了69.62% 的用户
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        char[] sch = s.toCharArray(), tch = t.toCharArray();
        for(int i = 0; i < sch.length; i++) {
            if(sch[i] != tch[i]) {          // 遇到不同的，就看看tch剩下的还有没有能匹配的
                for(int k = i; k < tch.length; k++) {
                    if(tch[k] == sch[i]) {    // 匹配上了，就交换一下。
                        swap(tch, i, k);
                        break;
                    }
                    if(k == sch.length - 1)   // 走到这里，说明没匹配上。
                        return false;
                }
            }
        }
        return true;
    }
    public void swap(char[] c, int pos1, int pos2) {
        char temp = c[pos1];
        c[pos1] = c[pos2];
        c[pos2] = temp;
    }
}

/*
解法二：排序
执行用时：3 ms, 在所有 Java 提交中击败了85.89% 的用户
内存消耗：39 MB, 在所有 Java 提交中击败了48.37% 的用户
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        char[] sch = s.toCharArray(), tch = t.toCharArray();
        Arrays.sort(sch);
        Arrays.sort(tch);
        return Arrays.equals(tch, sch);
    }
}

/*
解法三：制定一个26长度的数组，统计出现次数即可。
执行用时：2 ms, 在所有 Java 提交中击败了99.91% 的用户
内存消耗：38.6 MB, 在所有 Java 提交中击败了86.29% 的用户
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        char[] sch = s.toCharArray(), tch = t.toCharArray();
        int[] count = new int[26];
        for(char ch : sch)
            count[ch - 'a']--;
        for(char ch : tch)
            count[ch - 'a']++;
        for(int num : count)
            if(num != 0)
                return false;
        return true;
    }
}

