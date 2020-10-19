/*
寻找重复数
https://leetcode-cn.com/problems/find-the-duplicate-number/
给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
示例
输入: [1,3,4,2,2]
输出: 2
说明：
    不能更改原数组（假设数组是只读的）。
    只能使用额外的 O(1) 的空间。
    时间复杂度小于 O(n2) 。
    数组中只有一个重复的数字，但它可能不止重复出现一次。
*/

/*
解法：二分查找，对于某个正整数i，记数组中小于等于i的数字共f(i)个，则如果target比i大时，有f(i)<=i;如果target不比i大，则有f(n)-f(i)<=n-i,而f(n)=n+1,所以有f(i)>=i+1.
根据以上推导可以看出，f(i)<=i, if target>i; f(i)>i, if target<=i。因此可以使用二分法来夹逼得到target的值
执行用时：2 ms, 在所有 Java 提交中击败了64.18% 的用户
内存消耗：38 MB, 在所有 Java 提交中击败了99.86% 的用户
*/
class Solution {
    public int findDuplicate(int[] nums) {
        int right = nums.length - 1, left = 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if(fun(nums, mid) > mid)       // 如果f(mid) > mid，说明target ≤ mid
                right = mid;
            else                            // target > mid
                left = mid + 1;
        }
        return left;
    }
    public int fun(int[] nums, int n) {        // 统计小于等于n的个数
        int cnt = 0;
        for(int i = 0; i < nums.length; i++)
            if(nums[i] <= n)
                cnt++;
        return cnt;
    }
}


