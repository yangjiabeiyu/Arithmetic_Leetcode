/*
1128. 等价多米诺骨牌对的数量
https://leetcode-cn.com/problems/number-of-equivalent-domino-pairs/
给你一个由一些多米诺骨牌组成的列表 dominoes。
如果其中某一张多米诺骨牌可以通过旋转 0 度或 180 度得到另一张多米诺骨牌，我们就认为这两张牌是等价的。
形式上，dominoes[i] = [a, b] 和 dominoes[j] = [c, d] 等价的前提是 a==c 且 b==d，或是 a==d 且 b==c。
在 0 <= i < j < dominoes.length 的前提下，找出满足 dominoes[i] 和 dominoes[j] 等价的骨牌对 (i, j) 的数量。

示例：
输入：dominoes = [[1,2],[2,1],[3,4],[5,6]]
输出：1

提示：
    1 <= dominoes.length <= 40000
    1 <= dominoes[i][j] <= 9
*/

/*
解法一：遍历存入hash表
执行用时：14 ms, 在所有 Java 提交中击败了25.51% 的用户
内存消耗：47.9 MB, 在所有 Java 提交中击败了12.96% 的用户
*/
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        if(dominoes.length == 0 || dominoes[0].length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < dominoes.length; i++) {
            int num1 = 10 * dominoes[i][0] + dominoes[i][1], num2 = 10 * dominoes[i][1] + dominoes[i][0];  // num1和num2是等价的
            if(map.containsKey(num1))
                map.put(num1, map.get(num1) + 1);
            else if(map.containsKey(num2))
                map.put(num2, map.get(num2) + 1);
            else
                map.put(num1, 1);
        }
        int res = 0;
        for(Map.Entry<Integer, Integer> x : map.entrySet()) {
            int cnt = x.getValue();
            res += cnt * (cnt - 1) / 2;
        }
        return res;
    }
}

/*
遍历map的value也可以直接使用values()方法
执行用时：16 ms, 在所有 Java 提交中击败了21.43% 的用户
内存消耗：47.9 MB, 在所有 Java 提交中击败了15.84% 的用户
*/
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        if(dominoes.length == 0 || dominoes[0].length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < dominoes.length; i++) {
            int num1 = 10 * dominoes[i][0] + dominoes[i][1], num2 = 10 * dominoes[i][1] + dominoes[i][0];
            if(map.containsKey(num1))
                map.put(num1, map.get(num1) + 1);
            else if(map.containsKey(num2))
                map.put(num2, map.get(num2) + 1);
            else
                map.put(num1, 1);
        }
        int res = 0;
        for(int cnt : map.values()) {
            res += cnt * (cnt - 1) / 2;
        }
        return res;
    }
}

/*
解法三：既然元素都不大于9，所以可以用计数方法，使用一个大小为100的数组即可
执行用时：3 ms, 在所有 Java 提交中击败了85.51% 的用户
内存消耗：47.3 MB, 在所有 Java 提交中击败了87.24% 的用户
*/
class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        if(dominoes.length == 0 || dominoes[0].length == 0) return 0;
        int[] cnt = new int[100];
        int res = 0;
        for(int[] dominoe : dominoes) {
            int num = dominoe[0] < dominoe[1] ? 10 * dominoe[0] + dominoe[1] : 10 * dominoe[1] + dominoe[0];
            res += cnt[num];
            cnt[num]++;
        }
        return res;
    }
}

