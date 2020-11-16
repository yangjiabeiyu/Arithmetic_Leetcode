/*
67. 二进制求和
https://leetcode-cn.com/problems/add-binary/
给你两个二进制字符串，返回它们的和（用二进制表示）。
输入为 非空 字符串且只包含数字 1 和 0。

示例 1:
输入: a = "11", b = "1"
输出: "100"

示例 2:
输入: a = "1010", b = "1011"
输出: "10101"

提示：
    每个字符串仅由字符 '0' 或 '1' 组成。
    1 <= a.length, b.length <= 10^4
    字符串如果不是 "0" ，就都不含前导零。
*/

/*
解法：主要就是如果某个字符串到头了之后要置0，万能模板，几进制都行
执行用时：2 ms, 在所有 Java 提交中击败了98.85% 的用户
内存消耗：37.1 MB, 在所有 Java 提交中击败了90.50% 的用户
*/
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for(int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int x = i >= 0 ? a.charAt(i) - '0' : 0;
            int y = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            res.append(sum % 2);
            carry = sum / 2;
        }
        if(carry != 0) res.append(carry);
        return res.reverse().toString();
    }
}


