/*
69. x 的平方根

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
解法一：二分。通读代码之后，可以反思为什么这样写；
mid>temp说明target在mid左侧；而mid<temp，target可能就是mid，而left会取mid+1；
所以需要进行“挽回”，循环终止条件需要是left<=right，此时right会取为mid-1，所以最后是return right;
执行用时：2 ms, 在所有 Java 提交中击败了57.26% 的用户
内存消耗：35.7 MB, 在所有 Java 提交中击败了57.06% 的用户
*/
class Solution {
    public int mySqrt(int x) {
        if(x < 2) return x;  // 防止mid=0；也可以只讨论0，然后令left=1
        int left = 0, right = x;
        while(left <= right) {
            int mid = left + (right - left) / 2, temp = x / mid;  // 防止mid*mid越界，也不要mid=(left+right)/2，left+right也可能溢出
            if(mid == temp) return mid;
            else if(mid > temp) right = mid - 1;
            else left = mid + 1;
        }
        return right; 
    }
}

/*
解法二：二分，如果不考虑溢出，使用long，那就好多了
执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35.7 MB, 在所有 Java 提交中击败了59.92% 的用户
*/
class Solution {
    public int mySqrt(int x) {
        int left = 0, right = x, res = 0;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if((long)mid * mid < x) {
                res = mid;       // 记录位置
                left = mid + 1;
            }
            else if((long)mid * mid > x) 
                right = mid - 1;
            else return mid;
        }
        return res;
    }
}

// 也可以这样写
class Solution {
    public int mySqrt(int x) {
        int left = 0, right = x, res = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            if((long)mid * mid <= x) {
                res = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        return res;
    }
}
