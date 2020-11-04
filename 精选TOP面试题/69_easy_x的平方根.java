/*
69. x 的平方根
https://leetcode-cn.com/problems/sqrtx/
实现 int sqrt(int x) 函数。
计算并返回 x 的平方根，其中 x 是非负整数。
由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:
输入: 4
输出: 2

示例 2:
输入: 8
输出: 2
说明: 8 的平方根是 2.82842..., 
     由于返回类型是整数，小数部分将被舍去。
*/

/*
解法一：逐个查找
执行用时：46 ms, 在所有 Java 提交中击败了5.01% 的用户
内存消耗：35.7 MB, 在所有 Java 提交中击败了86.28% 的用户
*/
class Solution {
    public int mySqrt(int x) {
        for(int i = 0;; i++) {
            if(x >= i * i && x < (long)(i+1) * (i+1))
                return i;
        }
    }
}

/*
解法二：二分查找一
执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35.6 MB, 在所有 Java 提交中击败了87.69% 的用户
*/
class Solution {
    public int mySqrt(int x) {
        int left = 0, right = x;
        while(true) {
            int mid = (left + right) / 2;
            if((long)mid * mid <= x && (long)(mid + 1) * (mid + 1) > x)  // 此时mid就是想要的
                return mid;
            else if((long)mid * mid < x)
                left = mid + 1;
            else
                right = mid - 1;
        }
    }
}

/*
解法三：二分查找二：记录位置。
执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35.4 MB, 在所有 Java 提交中击败了93.25% 的用户
*/
class Solution {
    public int mySqrt(int x) {
        int left = 0, right = x, res = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            if((long)mid * mid <= x) {
                res = mid;      // 暂时记录位置，可能是最终答案
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        return res;
    }
}


