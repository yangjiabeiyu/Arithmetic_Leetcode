/*
14. 最长公共前缀

编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。

示例 1:
输入: ["flower","flow","flight"]
输出: "fl"

示例 2:
输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。

说明:
所有输入只包含小写字母 a-z 。
*/

/*
一般解法：逐个比较
执行用时：1 ms, 在所有 Java 提交中击败了88.49% 的用户
内存消耗：36.7 MB, 在所有 Java 提交中击败了79.56% 的用户
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        int num = strs[0].length();
        String str = strs[0];
        for(int i = 1; i < strs.length; i++) {
            int j = 0;
            for(; j < num && j < strs[i].length(); j++)
                if(str.charAt(j) != strs[i].charAt(j)) 
                    break;
            if(j == 0) return "";
            num = j;
        }
        return str.substring(0, num);
    }
}

