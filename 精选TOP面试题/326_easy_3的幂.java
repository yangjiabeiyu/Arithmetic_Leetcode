/*
326. 3的幂
https://leetcode-cn.com/problems/power-of-three/
给定一个整数，写一个函数来判断它是否是 3 的幂次方。

示例 1:
输入: 27
输出: true

示例 2:
输入: 0
输出: false

示例 3:
输入: 9
输出: true

示例 4:
输入: 45
输出: false
*/

/*
执行用时：14 ms, 在所有 Java 提交中击败了99.91% 的用户
内存消耗：38.4 MB, 在所有 Java 提交中击败了77.88% 的用户
*/
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n < 1)
            return false;
        while(n % 3 == 0)
            n = n / 3;
        return n == 1;
    }
}

