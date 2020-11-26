/*
413. 等差数列划分
https://leetcode-cn.com/problems/arithmetic-slices/
如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。

例如，以下数列为等差数列:
1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9

以下数列不是等差数列。

1, 1, 2, 5, 7

数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
如果满足以下条件，则称子数组(P, Q)为等差数组：
元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。

函数要返回数组 A 中所有为等差数组的子数组个数。

示例:
A = [1, 2, 3, 4]
返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
*/

/*
解法：统计最长的子等差数列，长度减2，然后使用公式num*（num+1）/2；加和所有的子数组即可。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：36.5 MB, 在所有 Java 提交中击败了54.66% 的用户
*/
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3) return 0;
        int[] dp = new int[A.length];
        int num = 0, res = 0;
        for(int i = 2; i < A.length; i++) {
            if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {     // 如果等差了，就加上1
                dp[i] = dp[i - 1] + 1;
                num = dp[i];   // 记录当前的最大长度（-2）
            }
            else {
                res += num * (num + 1) / 2;   // 如果不是等差的，就加上之前的子数组个数，并把num置0
                num = 0;
            }
        }
        return res + num * (num + 1) / 2;
    }
}

/*
解法二：解法一想麻烦了，假如遇到了新的A[i]，并且与之前的组成了等差数列，那么只需要加上A[i]参与的数列数即可，很显然就是【子数列长度-2】
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：36 MB, 在所有 Java 提交中击败了95.60% 的用户
*/
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3) return 0;
        int[] dp = new int[A.length];
        int res = 0;
        for(int i = 2; i < A.length; i++) {
            if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;    // 如果dp[i]=0,那么dp[i]=1,也就是3-2；
                res += dp[i];
            }
        }
        return res;
    }
}

