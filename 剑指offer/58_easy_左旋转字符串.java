/*
剑指 Offer 58 - II. 左旋转字符串
字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

示例 1：
输入: s = "abcdefg", k = 2
输出: "cdefgab"

示例 2：
输入: s = "lrloseumgh", k = 6
输出: "umghlrlose"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
/*
解法一：创建stringbuilder，逐个添加
执行用时：7 ms, 在所有 Java 提交中击败了12.93% 的用户
内存消耗：38.2 MB, 在所有 Java 提交中击败了98.25% 的用户
*/
class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder str = new StringBuilder();
        for(int i = n; i < n + s.length(); i++)
            str.append(s.charAt(i % s.length()));
        return str.toString();
    }
}

/*
解法二：剪切
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.1 MB, 在所有 Java 提交中击败了98.71% 的用户
*/
class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}

