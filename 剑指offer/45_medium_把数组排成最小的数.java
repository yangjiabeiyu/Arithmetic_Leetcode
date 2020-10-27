/*
剑指 Offer 45. 把数组排成最小的数
https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/
输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。

示例 1:
输入: [10,2]
输出: "102"

示例 2:
输入: [3,30,34,5,9]
输出: "3033459"

提示:
    0 < nums.length <= 100
说明:
    输出结果可能非常大，所以你需要返回一个字符串而不是整数
    拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
*/

/*
解法：需要对数组排序，排序方式是，对于x和y，如果xy < yx，则有 x < y，这样可以保证从前到后组成的数字最小。
执行用时：5 ms, 在所有 Java 提交中击败了98.59% 的用户
内存消耗：37.8 MB, 在所有 Java 提交中击败了98.79% 的用户
*/
class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];     // 转为字符串数组
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        qSort(strs, 0, strs.length - 1);            // 对数组排序
        StringBuilder sb = new StringBuilder();     // 存储结果
        for(int i = 0; i < nums.length; i++)
            sb.append(strs[i]);
        return sb.toString();        // 转为字符串
    }
    public void qSort(String[] strs, int left, int right) {
        if(left >= right)    // 终止条件
            return;
        String value = strs[left];   // 设置目标值，小于等于目标值放左边，大于等于放右边
        int i = left, j = right;
        while(i < j) {
            while((value + strs[j]).compareTo(strs[j] + value) <= 0 && i < j)
                j--;
            while((value + strs[i]).compareTo(strs[i] + value) >= 0 && i < j)
                i++;
            if(i < j) {
                String temp = strs[i];
                strs[i] = strs[j];
                strs[j] = temp;
            }
        }
        strs[left] = strs[i];     // 将首位置与中间点交换位置，由于是先从j开始左移，因此i指向的数字必然不会大于target
        strs[i] = value;
        qSort(strs, left, i - 1);      // 向下递归
        qSort(strs, i + 1, right);
    }
}

/*
解法二：使用内置快排函数，自定义比较器
执行用时：6 ms, 在所有 Java 提交中击败了89.40% 的用户
内存消耗：37.8 MB, 在所有 Java 提交中击败了98.92% 的用户
*/
class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (p1, p2) -> (p1 + p2).compareTo(p2 + p1));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; i++)
            sb.append(strs[i]);
        return sb.toString();
    }
}

