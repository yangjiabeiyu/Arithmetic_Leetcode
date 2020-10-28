/*
557. 反转字符串中的单词 III
https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例：
输入："Let's take LeetCode contest"
输出："s'teL ekat edoCteeL tsetnoc"

提示：
    在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
*/

/*
解法：先切片，然后逐个对单词翻转
执行用时：7 ms, 在所有 Java 提交中击败了62.65% 的用户
内存消耗：38.8 MB, 在所有 Java 提交中击败了99.30% 的用户
*/
class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < strs.length; i++)
            res.append(reverseWord(strs[i]) + " ");
        res.deleteCharAt(res.length() - 1);   // 删除尾空格
        return res.toString();
    }
    public String reverseWord(String s) {
        char[] c = s.toCharArray();    // 转为字符数组
        int i = 0, j = c.length - 1;
        while(i < j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(c);
    }
}

