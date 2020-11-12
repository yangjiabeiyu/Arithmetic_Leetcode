/*
58. 最后一个单词的长度
https://leetcode-cn.com/problems/length-of-last-word/
给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
如果不存在最后一个单词，请返回 0 。
说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。

示例:
输入: "Hello World"
输出: 5
*/

/*
解法：从后向前遍历即可
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：37 MB, 在所有 Java 提交中击败了47.35% 的用户
*/
class Solution {
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        while(index >= 0 && s.charAt(index) == ' ')
            index--;
        if(index < 1) return index + 1;
        int start = index;
        while(start >= 0 && s.charAt(start) != ' ')
            start--;
        return index - start;
    }
}

