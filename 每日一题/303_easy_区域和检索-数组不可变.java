/*
303. 区域和检索 - 数组不可变
https://leetcode-cn.com/problems/range-sum-query-immutable/
给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。
实现 NumArray 类：
    NumArray(int[] nums) 使用数组 nums 初始化对象
    int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）

示例：
输入：
["NumArray", "sumRange", "sumRange", "sumRange"]
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
输出：
[null, 1, -1, -3]

解释：
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
numArray.sumRange(0, 2); // return 1 ((-2) + 0 + 3)
numArray.sumRange(2, 5); // return -1 (3 + (-5) + 2 + (-1)) 
numArray.sumRange(0, 5); // return -3 ((-2) + 0 + 3 + (-5) + 2 + (-1))
*/

/*
解法：创建数组，保存前i项的和，在查询时，只需要找到对应位置相减即可。
执行用时：10 ms, 在所有 Java 提交中击败了91.63% 的用户
内存消耗：41.4 MB, 在所有 Java 提交中击败了80.18% 的用户
*/
class NumArray {
    private int[] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++)
            sum[i + 1] = sum[i] + nums[i];
    }
    
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}

