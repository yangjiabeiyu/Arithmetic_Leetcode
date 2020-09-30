/*
爬楼梯
https://leetcode-cn.com/problems/climbing-stairs/
问题描述
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
示例
输入： 2  输出： 2
解释： 有两种方法可以爬到楼顶。1. 1 阶 + 1 阶  2. 2 阶
*/

/*
解法一：直接递归
超时
*/
class Solution {
    public int climbStairs(int n) {
        if(n <= 2)
            return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

/*
解法二：使用map记录下计算过的n阶对应的方法，减少计算量
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35.8 MB, 在所有 Java 提交中击败了5.42% 的用户
*/
class Solution {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        return climbStairs(map, n);
    }
    public int climbStairs(HashMap map, int n) {
        if(n <= 2)
            return n;
        if(map.containsKey(n))
            return (Integer)map.get(n);   // 如果已记录，则直接返回
        else {
            int value = climbStairs(map, n - 1) + climbStairs(map, n - 2);  // 未记录则进行计算
            map.put(n, value);
            return value;
        }
    }
}

/*
解法三：使用迭代方法
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35.7 MB, 在所有 Java 提交中击败了16.60% 的用户
*/
class Solution {
    public int climbStairs(int n) {
        if(n <= 2)
            return n;
        int m1 = 1, m2 = 2, k = 0;
        for(int i = 2; i < n; i++) {
            k = m1 + m2;
            m1 = m2;
            m2 = k;
        }
        return k;
    }
}

