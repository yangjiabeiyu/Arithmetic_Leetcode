/*
9. 回文数
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:
输入: 121
输出: true

示例 2:
输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

示例 3:
输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。

进阶:
你能不将整数转为字符串来解决这个问题吗？
*/

/*
解法：将数字翻转一般即可，全部翻转可能出现越界的问题
执行用时：10 ms, 在所有 Java 提交中击败了77.01% 的用户
内存消耗：37.9 MB, 在所有 Java 提交中击败了88.13% 的用户
*/
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) return false;
        int temp = 0;
        while(x >= temp) {
            if(x == temp || x / 10 == temp)        // 主要应对偶数位或者奇数位
                return true;
            temp = temp * 10 + x % 10;
            x = x / 10;
        }
        return false;
    }
}

