/*
334. 递增的三元子序列

给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
数学表达式如下:
    如果存在这样的 i, j, k,  且满足 0 ≤ i < j < k ≤ n-1，
    使得 arr[i] < arr[j] < arr[k] ，返回 true ; 否则返回 false 。

说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
示例 1:
输入: [1,2,3,4,5]   输出: true
示例 2:
输入: [5,4,3,2,1]   输出: false
*/

/*
解法：保留一个small、mid；如果新的num大于mid，返回true；如果新的num小于mid，则更新mid；如果新的num小于small，则更新small。
不用担心之前的small没了，毕竟mid还在，它还隐含着前面有个之前的small。
执行用时：1 ms, 在所有 Java 提交中击败了49.65% 的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了74.41% 的用户
*/
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;
        int small = nums[0], mid = Integer.MAX_VALUE;
        for(int num : nums) {
            if(num > mid)
                return true;
            else if(num <= small)
                small = num;
            else if(num < mid)
                mid = num;
        }
        return false;
    }
}


/*
解法二：动态规划，dp[i]表示以nums[i]结尾时，最大的递增序列长度；但该方法不满足O(n)的空间复杂度。
执行用时：68 ms, 在所有 Java 提交中击败了9.21% 的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了70.18% 的用户
*/
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length == 0) return false;
        int[] dp = new int[nums.length];
        for(int i = 1; i < nums.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if(dp[i] == 2)
                        return true;
                }
            }
        }
        return false;
    }
}

