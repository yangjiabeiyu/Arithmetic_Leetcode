/*
454. 四数相加 II

给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。

例如:
输入:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

输出:
2

解释:
两个元组如下:
1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
*/

/*
解法：先hashmap存储A与B的加和及其次数，然后遍历C和D，统计加和为0的次数
执行用时：83 ms, 在所有 Java 提交中击败了47.26% 的用户
内存消耗：57.5 MB, 在所有 Java 提交中击败了62.20% 的用户
*/
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if(A.length == 0 || B.length == 0 || C.length == 0 || D.length == 0)
            return 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++)                // 存储A和B各元素加和
            for(int j = 0; j < B.length; j++) {
                int temp = A[i] + B[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        
        for(int i = 0; i < C.length; i++)
            for(int j = 0; j < D.length; j++) {
                int temp = -C[i] - D[j];
                res += map.getOrDefault(temp, 0);         // 得到次数和
            }
        return res;
    }
}

