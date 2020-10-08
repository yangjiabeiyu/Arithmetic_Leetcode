/*
汉明距离
https://leetcode-cn.com/problems/hamming-distance/
题目描述
两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。给出两个整数 x 和 y，计算它们之间的汉明距离。
注意：0 ≤ x, y < 2^31.
示例
输入: x = 1, y = 4    输出: 2
解释:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
上面的箭头指出了对应二进制位不同的位置。
*/

/*
解法一：不断移位，可以递归，也可以不断迭代，这里给出递归
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35.6 MB, 在所有 Java 提交中击败了46.45% 的用户
*/
class Solution {
    public int hammingDistance(int x, int y) {
        if(x == 0 && y == 0)
            return 0;
        return (x % 2 == y % 2 ? 0 : 1) + hammingDistance(x >> 1, y >> 1);
    }
}

/*
解法二：先异或，然后移位统计1的数量
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35.7 MB, 在所有 Java 提交中击败了31.97% 的用户
*/
class Solution {
    public int hammingDistance(int x, int y) {
        int a = x ^ y, cnt = 0;
        while(a != 0) {
            if((a & 1) == 1)
                cnt++;
            a = a >> 1;
        }
        return cnt;
    }
}
