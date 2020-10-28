/*
202. 快乐数
https://leetcode-cn.com/problems/happy-number/
编写一个算法来判断一个数 n 是不是快乐数。
「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
如果 n 是快乐数就返回 True ；不是，则返回 False 。

示例：
输入：19
输出：true
解释：
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
*/

/*
解法一：经过测试，非快乐数会遇到一个循环，而且比较固定。所以直接设置一个循环中的数字，遇到了就直接break
执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35.2 MB, 在所有 Java 提交中击败了97.33% 的用户
*/
class Solution {
    public boolean isHappy(int n) {
        while(true) {
            int val = 0;
            while(n > 0) {
                val += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = val;
            if(val == 1)
                return true;
            if(val == 4)
                return false;
       }
    }
}

/*
解法二：既然会有循环，那么就快慢指针
执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35.5 MB, 在所有 Java 提交中击败了89.77% 的用户
*/
class Solution {
    public boolean isHappy(int n) {
        int slow = getValue(n), fast = getValue(getValue(n));
        while(slow != fast) {
            slow = getValue(slow);
            fast = getValue(getValue(fast));
        }
        return slow == 1;
    }
    public int getValue(int n) {
        int val = 0;
        while(n > 0) {
            val += Math.pow(n % 10, 2);
            n /= 10;
        }
        return val;
    }
}


