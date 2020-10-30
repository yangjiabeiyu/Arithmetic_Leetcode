/*
204. 计数质数

统计所有小于非负整数 n 的质数的数量。

示例 1：
输入：n = 10
输出：4
解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。

示例 2：
输入：n = 0
输出：0

示例 3：
输入：n = 1
输出：0
*/

/*
解法一：建立质数表，直接在质数表上遍历，以判断新的数字是否为质数，但是超时，就算引入跳过2和3的倍数
*/
class Solution {
    public int countPrimes(int n) {
        List<Integer> list = new ArrayList<>();
        if(n <= 2) return 0;
        for(int i = 2; i < n; i++) {
            if(i > 6 && (i % 2 == 0 || i % 3 == 0))
                continue;
            boolean flag = true;
            for(int k = 0; k < list.size(); k++)
                if(i % list.get(k) == 0)
                    flag = false;
            if(flag) list.add(i);
        }
        return list.size();
    }
}

/*
解法二：从2开始，那么2的倍数肯定不是素数，进而3以及3的倍数不是素数；每找到一个素数，就把其倍数置为非素数。
执行用时：13 ms, 在所有 Java 提交中击败了87.69% 的用户
内存消耗：37.2 MB, 在所有 Java 提交中击败了58.41% 的用户
*/
class Solution {
    public int countPrimes(int n) {
        int res = 0, sq = (int)Math.sqrt(n);
        boolean[] dp = new boolean[n];
        for(int i = 2; i <= sq; i++)  // 只需要到根号n，因为更大的数的约数必然是小于等于根号n的
            if(!dp[i]) {
                res++;
                for(int k = i * i; k < n; k += i)  // 从i平方开始
                    dp[k] = true;
            }
        for(int k = sq + 1; k < n; k++)  // 统计后面的素数个数
            if(!dp[k]) res++;
        return res;

    }
}

