/*
231. 2的幂
https://leetcode-cn.com/problems/power-of-two/
给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

示例 1:
输入: 1
输出: true
解释: 20 = 1

示例 2:
输入: 16
输出: true
解释: 24 = 16

示例 3:
输入: 218
输出: false
*/

/*
解法一：看看二进制是不是只有一个1
执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35.3 MB, 在所有 Java 提交中击败了95.53% 的用户
*/
class Solution {
    public boolean isPowerOfTwo(int n) {
        while(n > 0) {
            if((n & 1) == 1){
                if(n == 1)
                    return true;
                return false;
            }
            n >>= 1;
        }
        return false;
    }
}

/*
解法二：x与x-1
执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35.5 MB, 在所有 Java 提交中击败了91.70% 的用户
*/
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        return (n & n - 1) == 0;
    }
}


