/*
171. Excel表列序号
https://leetcode-cn.com/problems/excel-sheet-column-number/
给定一个Excel表格中的列名称，返回其相应的列序号。
例如，
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
示例 1:
输入: "A"
输出: 1

示例 2:
输入: "AB"
输出: 28
*/

/*
解法：二十六进制
执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.4 MB, 在所有 Java 提交中击败了12.61% 的用户
*/
class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++)
            res = 26 * res + s.charAt(i) - 'A' + 1;
        return res;
    }
}

