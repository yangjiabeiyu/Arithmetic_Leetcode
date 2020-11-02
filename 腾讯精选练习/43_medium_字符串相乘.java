/*
43. 字符串相乘
https://leetcode-cn.com/problems/multiply-strings/
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:
输入: num1 = "2", num2 = "3"
输出: "6"

示例 2:
输入: num1 = "123", num2 = "456"
输出: "56088"

说明：
    num1 和 num2 的长度小于110。
    num1 和 num2 只包含数字 0-9。
    num1 和 num2 均不以零开头，除非是数字 0 本身。
    不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
*/

/*
解法一：仿照计算式，先让字符串与单字符相乘，然后字符串相加。需要注意的是，字符串需要根据所在位置，向左移位。
执行用时：25 ms, 在所有 Java 提交中击败了27.37% 的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了94.05% 的用户
*/
class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2))
            return "0";
        String res = "";
        int n = num1.length();
        for(int i = n - 1; i >= 0; i--)   // 得到相乘值，然后累加
            res = plus(res, multiplySingle(num2, num1.charAt(i) - '0', n - 1 - i));
        return res;
    }
    public String multiplySingle(String num, int ch, int cnt) {    // 字符串与单字符相乘，cnt表示移位数
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cnt; i++)  // 先补0，后面翻转后相当于在末尾补0，实现移位的效果
            sb.append(0);
        int carry = 0;   // 进位
        for(int i = num.length() - 1; i >= 0; i--) {
            int res = (num.charAt(i) - '0') * ch + carry;  // 先计算结果
            sb.append(res % 10);   // 记录当前位
            carry = res / 10;   // 刷新进位
        }
        if(carry != 0) sb.append(carry);  // carry非0，则添加
        return sb.reverse().toString();
    }
    public String plus(String num1, String num2) {       // 字符串相加
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;   // 相当于补0了
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int res = x + y + carry;
            sb.append(res % 10);
            carry = res / 10;
        }
        if(carry != 0) sb.append(carry);    // 添加carry
        return sb.reverse().toString();
    }
}

/*
解法二：优化的竖式相乘，主要思路在于，对于位于pos1和pos2的两个数字相乘后，会得到0y或xy，而且y位于pos1+pos2处。
举个例子，"123"与"456"的"2"(pos1=1)与"5"(pos2=1)相乘得到"10",则"0"位于竖式计算的倒数第三位，也即是pos为2；这样就可以先初始化各位为0，然后不断累加。
执行用时：4 ms, 在所有 Java 提交中击败了84.22% 的用户
内存消耗：38.6 MB, 在所有 Java 提交中击败了93.66% 的用户
*/
class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2))
            return "0";
        int[] temp = new int[num1.length() + num2.length()];   // 最多这么多位
        for(int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';  // 先记录当前位
            for(int j = num2.length() - 1; j >= 0; j--) {
                int sum = n1 * (num2.charAt(j) - '0') + temp[i + j + 1];     // 计算乘积，并加上之前的数字
                temp[i + j + 1] = sum % 10;   // 更新
                temp[i + j] += sum / 10;   // 更新
            }
        }
        StringBuilder res = new StringBuilder();   // 第一位可能是0，所以需要判断一下
        for(int i = 0; i < temp.length; i++) {
            if(temp[i] == 0 && i == 0) continue;
            res.append(temp[i]);
        }
        return res.toString();
    }
}

