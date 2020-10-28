/*
134. 加油站
https://leetcode-cn.com/problems/gas-station/
在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。

说明: 
    如果题目有解，该答案即为唯一答案。
    输入数组均为非空数组，且长度相同。
    输入数组中的元素均为非负数。

示例 1:
输入: 
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]
输出: 3

解释:
从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
因此，3 可为起始索引。

示例 2:
输入: 
gas  = [2,3,4]
cost = [3,4,3]
输出: -1

解释:
你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
因此，无论怎样，你都不可能绕环路行驶一周。
*/

/*
解法一：设置总油量totalGas和当前油量curGas；从头开始走，如果curGas为0，这说明开始位置到达不了该位置，包括之前的位置也到达不了；此时清空curGas，从下一个位置开始跑；
遍历下来，如果totalGas是小于0的，那必然是不可以的。
*/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curGas = 0, totalGas = 0, pos = 0;
        for(int j = 0; j < gas.length; j++) {
            curGas += gas[j] - cost[j];
            totalGas += gas[j] - cost[j];
            if(curGas < 0) {
                curGas = 0;
                pos = j + 1;     // 此处不会越界到gas.length，如果在n-1处跑不动了，这也就说明前面会有1个或多个段，curGas<0，此时totalGas必然是<0的，所以不用担心越界。
            }
        }
        return totalGas >= 0 ? pos : -1;
    }
}

/*
解法二：其实可以画一个图，从头开始走的总油量曲线，即使小于0也没关系；如果最终的总油量小于0，那必然不行。如果大于等于0，可以将曲线向上平移至x轴上方。
那必然是要找到最小值，然后将其下一个位置作为起点即可。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.9 MB, 在所有 Java 提交中击败了83.55% 的用户
*/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, maxGas = Integer.MAX_VALUE, pos = 0;
        for(int j = 0; j < gas.length; j++) {
            totalGas += gas[j] - cost[j];
            if(maxGas > totalGas) {
                maxGas = totalGas;
                pos = j + 1;
            }
        }
        return totalGas >= 0 ? pos % gas.length : -1;
    }
}

