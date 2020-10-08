/*
反转字符串
https://leetcode-cn.com/problems/reverse-string/
题目描述
输入字符串以字符数组 char[] 的形式给出，将输入的字符串反转过来。
不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
示例
输入：["h","e","l","l","o"]    输出：["o","l","l","e","h"]
*/

/*
解法：双指针，头尾指针向中间移动
执行用时：1 ms, 在所有 Java 提交中击败了99.98% 的用户
内存消耗：45.3 MB, 在所有 Java 提交中击败了76.41% 的用户
*/
class Solution {
    public void reverseString(char[] s) {
        int right = s.length - 1;
        for(int left = 0; left < right; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}
