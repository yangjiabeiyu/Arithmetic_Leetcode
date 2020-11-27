/*
474. 一和零
https://leetcode-cn.com/problems/ones-and-zeroes/
给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。

示例 1：
输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
输出：4
解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。

示例 2：
输入：strs = ["10", "0", "1"], m = 1, n = 1
输出：2
解释：最大的子集是 {"0", "1"} ，所以答案是 2 。
*/

/*
三维dp
执行用时：79 ms, 在所有 Java 提交中击败了24.13% 的用户
内存消耗：67.2 MB, 在所有 Java 提交中击败了23.13% 的用户
*/
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs.length == 0 || (m == 0 && n == 0)) return 0;     // 注意这里m和n同时为0的时候才return
        int[][][] dp = new int[strs.length + 1][m + 1][n + 1];   // 第一维表示物体件数，第二维表示0，第三维表示1
        for(int i = 1; i <= strs.length; i++) {
            int[] num = getnums(strs[i - 1]);     // 得到当前物体需要的0和1的数量
            for(int j = 0; j <= m; j++) {         // 注意这里都是从0开始，因为可以不需要0或者1
                for(int k = 0; k <= n; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if(j >= num[0] && k >= num[1])   
                        dp[i][j][k] = Math.max(dp[i - 1][j - num[0]][k - num[1]] + 1, dp[i][j][k]);
                }
            }
        }
        return dp[strs.length][m][n];
    }
    public int[] getnums(String s) {      // 获取0和1的数量
        int[] num = new int[2];
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i) == '0') num[0]++;
            else num[1]++;
        return num;
    }
}

/*
二维dp，背包问题一般可以降一个维度，由于要用到上一物品的信息，而且信息在前侧，所以需要逆向更新
执行用时：39 ms, 在所有 Java 提交中击败了69.65% 的用户
内存消耗：37.9 MB, 在所有 Java 提交中击败了82.81% 的用户
*/
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        if(strs.length == 0 || (m == 0 && n == 0)) return 0;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < strs.length; i++) {
            int[] num = getnums(strs[i]);
            for(int j = m; j >= num[0]; j--) {       // 逆向更新，直到num[0]
                for(int k = n; k >= num[1]; k--) {
                    dp[j][k] = Math.max(dp[j - num[0]][k - num[1]] + 1, dp[j][k]);
                }
            }
        }
        return dp[m][n];
    }
    public int[] getnums(String s) {
        int[] num = new int[2];
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i) == '0') num[0]++;
            else num[1]++;
        return num;
    }
}

