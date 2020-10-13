/*
和为k的子数组
https://leetcode-cn.com/problems/subarray-sum-equals-k/
题目描述
给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
示例
输入:nums = [1,1,1], k = 2    输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
说明 :
    数组的长度为 [1, 20,000]。
    数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
*/

/*
解法一：二次遍历
执行用时：449 ms, 在所有 Java 提交中击败了19.14% 的用户
内存消耗：39.8 MB, 在所有 Java 提交中击败了64.78% 的用户
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                sum += nums[j];
                if(sum == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

/*
解法二：我们记前i个数字的和为s[i]，那么如果对于j，0 < j < i，如果s[j] = s[i] - k，则说明[j+1, i]这个字串符合要求。
因此在遍历的时候记录下来s[i]及其出现的次数，一次遍历即可。
执行用时：26 ms, 在所有 Java 提交中击败了48.94% 的用户
内存消耗：39.6 MB, 在所有 Java 提交中击败了80.14% 的用户
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int cnt = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);    // key代表子序列加和，value代表次数
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            cnt += map.containsKey(sum - k) ? map.get(sum - k) : 0;
            int num = map.containsKey(sum) ? map.get(sum) : 0;
            map.put(sum, num + 1);
        }
        return cnt;
    }
}

/*
放入sum值的时候，也可以优化一下
执行用时：22 ms, 在所有 Java 提交中击败了78.35% 的用户
内存消耗：39.4 MB, 在所有 Java 提交中击败了95.39% 的用户
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int cnt = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);    // key代表子序列加和，value代表次数
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - k))
                cnt += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }
}
