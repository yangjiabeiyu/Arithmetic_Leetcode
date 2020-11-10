/*
179. 最大数
https://leetcode-cn.com/problems/largest-number/
给定一组非负整数 nums，重新排列它们每位数字的顺序使之组成一个最大的整数。
注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。

示例 1：
输入：nums = [10,2]
输出："210"

示例 2：
输入：nums = [3,30,34,5,9]
输出："9534330"
*/

/*
解法：重定义排序规则即可。同时需要注意的是，如果答案是0000，需要改为0。这个很好处理，只需要检查第一个元素是不是0，如果是，直接返回0就行。
执行用时：6 ms, 在所有 Java 提交中击败了93.22% 的用户
内存消耗：38.3 MB, 在所有 Java 提交中击败了80.70% 的用户
*/
class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String p, String q) {
                return (q + p).compareTo(p + q);
            }
        });
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < nums.length; i++)
            res.append(strs[i]);
        if(res.charAt(0) == '0')
            return "0";
        return res.toString();
    }
}

