/*
135. 分发糖果
https://leetcode-cn.com/problems/candy/
老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
你需要按照以下要求，帮助老师给这些孩子分发糖果：
    每个孩子至少分配到 1 个糖果。
    相邻的孩子中，评分高的孩子必须获得更多的糖果。
那么这样下来，老师至少需要准备多少颗糖果呢？

示例 1:
输入: [1,0,2]
输出: 5
解释: 你可以分别给这三个孩子分发 2、1、2 颗糖果。

示例 2:
输入: [1,2,2]
输出: 4
解释: 你可以分别给这三个孩子分发 1、2、1 颗糖果。
     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。
*/

/*
解法：贪心，正序遍历，如果右边大，右边就加一；倒序遍历，如果左边大，而且需要保证左边比其左右两侧大，即取【原有值】与【右边值+1】中的较大值。
执行用时：3 ms, 在所有 Java 提交中击败了72.64% 的用户
内存消耗：39.2 MB, 在所有 Java 提交中击败了95.41% 的用户
*/
class Solution {
    public int candy(int[] ratings) {
        int[] arr = new int[ratings.length];
        Arrays.fill(arr, 1);
        for(int i = 1; i < arr.length; i++)
            if(ratings[i] > ratings[i - 1])
                arr[i] = arr[i - 1] + 1;
        int res = arr[arr.length - 1];
        for(int i = arr.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1])
                arr[i] = Math.max(arr[i], arr[i + 1] + 1);
            res += arr[i];
        }
        return res;
    }
}

