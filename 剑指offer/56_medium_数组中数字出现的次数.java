/*
剑指 Offer 56 - II. 数组中数字出现的次数 II
在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

示例 1：
输入：nums = [3,4,3,3]
输出：4

示例 2：
输入：nums = [9,1,7,9,7,9,7]
输出：1

限制：

    1 <= nums.length <= 10000
    1 <= nums[i] < 2^31

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
解法一：map存储次数
执行用时：17 ms, 在所有 Java 提交中击败了28.41% 的用户
内存消耗：39.7 MB, 在所有 Java 提交中击败了75.35% 的用户
*/
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for(int num : map.keySet())
            if(map.get(num) == 1)
                return num;
        return 0;
    }
}

/*
解法二：出现三遍的数字，每一位的加和都会是3的倍数，所以只需要按位加和，对3的余数即是出现一遍的数字的各位。
执行用时：5 ms, 在所有 Java 提交中击败了86.05% 的用户
内存消耗：39 MB, 在所有 Java 提交中击败了99.96% 的用户
*/
class Solution {
    public int singleNumber(int[] nums) {
        int[] sum = new int[32];
        for(int num : nums)           // 累加各位
            for(int i = 0; i < 32; i++) {
                sum[i] += num & 1;
                num = num >>> 1;
            }
        for(int i = 0; i < 32; i++)   // 对3取余
            sum[i] %= 3;
        int res = 0;
        for(int i = 31; i >= 0; i--) {          // 恢复res，先左移，然后取或，把sum[i]给加到末尾，注意i是从31，也就是末位开始的
            res <<= 1;
            res |= sum[i]; 
        }
        return res;
    }
}

