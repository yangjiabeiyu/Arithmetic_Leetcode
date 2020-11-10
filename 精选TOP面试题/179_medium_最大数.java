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

/*
自己写快排
执行用时：6 ms, 在所有 Java 提交中击败了93.22% 的用户
内存消耗：38 MB, 在所有 Java 提交中击败了91.42% 的用户
*/
class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        qSort(strs, 0, strs.length - 1);
        if(strs[0].charAt(0) == '0')
            return "0";
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < nums.length; i++)
            res.append(strs[i]);
        
        return res.toString();
    }
    public void qSort(String[] strs, int left, int right) {
        if(left >= right)
            return;
        String temp = strs[left];
        int i = left, j = right;
        while(i < j) {
            while((temp + strs[j]).compareTo(strs[j] + temp) >= 0 && i < j)   //这里等于号
                j--;
            while((temp + strs[i]).compareTo(strs[i] + temp) <= 0 && i < j)
                i++;
            if(i < j)     // 这里别忘了判断
                swap(strs, i, j);
        }
        swap(strs, left, i);
        qSort(strs, left, i - 1);
        qSort(strs, i + 1, right);
    }
    public void swap(String[] strs, int p1, int p2) {
        String temp = strs[p1];
        strs[p1] = strs[p2];
        strs[p2] = temp;
    }
}


