/*
125. 验证回文串
https://leetcode-cn.com/problems/valid-palindrome/
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:
输入: "A man, a plan, a canal: Panama"
输出: true

示例 2:
输入: "race a car"
输出: false
*/

/*
解法：先转为小写，然后首尾指针。
执行用时：4 ms, 在所有 Java 提交中击败了66.46% 的用户
内存消耗：38.7 MB, 在所有 Java 提交中击败了79.32% 的用户
*/
class Solution {
    public boolean isPalindrome(String s) {
        char[] c = s.toLowerCase().toCharArray();
        int left = 0, right = c.length - 1;
        while(left < right) {     
            while(!isLetterOrDigit(c[left]) && left < right)         // 不是字母或数字就跳过
                left++;
            while(!isLetterOrDigit(c[right]) && left < right)
                right--;
            if(c[left] == c[right]) {        // 判断是否相等
                left++;
                right--;
            }
            else break;
        }
        return left >= right;
    }
    public boolean isLetterOrDigit(char ch) {          // 判断是否是字母或者数字
        if((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))
            return true;
        return false;
    }
}

