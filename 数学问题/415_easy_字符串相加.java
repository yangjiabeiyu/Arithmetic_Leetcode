/*
415. 字符串相加
https://leetcode-cn.com/problems/add-strings/
给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。

提示：
    num1 和num2 的长度都小于 5100
    num1 和num2 都只包含数字 0-9
    num1 和num2 都不包含任何前导零
    你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
*/

/*
执行用时：3 ms, 在所有 Java 提交中击败了70.61% 的用户
内存消耗：38.4 MB, 在所有 Java 提交中击败了82.46% 的用户
*/
class Solution {
    public String addStrings(String num1, String num2) {
        int m = num1.length(), n = num2.length(), i = 1, carry = 0;
        StringBuilder res = new StringBuilder();
        while(i <= m || i <= n) {
            int j = i <= m ? num1.charAt(m - i) - '0' : 0, k = i <= n ? num2.charAt(n - i) - '0' : 0;
            res.append((j + k + carry) % 10);
            carry = (j + k + carry) / 10;
            i++;
        }
        if(carry != 0) res.append(carry);
        return res.reverse().toString();
    }
}

/*
执行用时：2 ms, 在所有 Java 提交中击败了99.68% 的用户
内存消耗：38.4 MB, 在所有 Java 提交中击败了82.27% 的用户
*/
class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder res = new StringBuilder();
        while(i >= 0 || j >= 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0, y = j >= 0 ? num2.charAt(j) - '0' : 0;
            res.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
            i--;
            j--;
        }
        if(carry != 0) res.append(carry);
        return res.reverse().toString();
    }
}

