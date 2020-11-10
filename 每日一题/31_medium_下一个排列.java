/*
31. 下一个排列
https://leetcode-cn.com/problems/next-permutation/
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

/*
解法：从右端开始，找第一个nums[i]<nums[i+1]，这样可以保证nums[i]是移到右边的数字（不会牵涉到前面的高位）；
然后需要找到移到左边的数字，这肯定是nums[i]右边数字中比nums[i]大且最接近它的数字；找到之后交换，然后对nums[i]右侧的数字进行升序排序，
但考虑到右侧必然是降序的，因此只需要简单翻转即可。
执行用时：1 ms, 在所有 Java 提交中击败了98.72% 的用户
内存消耗：38.6 MB, 在所有 Java 提交中击败了86.22% 的用户
*/
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 0) return;
        int i = nums.length - 2;
        for(; i >= 0; i--) {
            if(nums[i] < nums[i + 1]) {   // 找到右移的数字nums[i]
                int k = nums.length - 1;
                for(; k > i; k--) {
                    if(nums[i] < nums[k])   // 找到左移的数字nums[k]
                        break;
                }
                swap(nums, i, k);     // 交换
                break;
            }
        }
        reverse(nums, i + 1);   // 翻转
    }
    public void swap(int[] nums, int p1, int p2) {
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }
    public void reverse(int[] nums, int start) {
        int right = nums.length - 1;
        while(start < right) {
            swap(nums, start, right);
            start++;
            right--;
        }
    }
}



