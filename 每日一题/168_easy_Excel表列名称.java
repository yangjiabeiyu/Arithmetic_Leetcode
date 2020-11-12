/*
168. Excel表列名称

给定一个正整数，返回它在 Excel 表中相对应的列名称。

例如，
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...

示例 1:
输入: 1
输出: "A"

示例 2:
输入: 28
输出: "AB"

示例 3:
输入: 701
输出: "ZY"
*/

/*
解法：主要是先把n-1，因为A~Z是1~26，应该降为0~25，这样除以26的余数才为0。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35.7 MB, 在所有 Java 提交中击败了80.94% 的用户
*/
class Solution {
    public String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while(n > 0) {
            n -= 1;
            char ch = (char)('A' + n % 26);
            res.append(ch);
            n /= 26;
        }
        return res.reverse().toString();
    }
}


