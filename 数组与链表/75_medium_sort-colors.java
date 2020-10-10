/*
颜色分类
https://leetcode-cn.com/problems/sort-colors/
题目描述
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
注意:不能使用代码库中的排序函数来解决这道题。
进阶：
    一个直观的解决方案是使用计数排序的两趟扫描算法。
    首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
    你能想出一个仅使用常数空间的一趟扫描算法吗？
示例
输入: [2,0,2,1,1,0]    输出: [0,0,1,1,2,2]
*/

/*
解法：三指针，一个来遍历，当遇到2，就放到最后，遇到0就放到最前
*/

/*
解法一：遇到2就和尾指针交换，遇到0就直接让记录0的指针前移，后续再补全。但该方法不是仅扫描一次，因为还要从j到i补1
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：37.6 MB, 在所有 Java 提交中击败了13.53% 的用户
*/
class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = 0;
        for(int k = nums.length - 1; i <= k;) {
            if(nums[i] == 2) {
                nums[i] = nums[k];
                nums[k--] = 2;
            }
            else if(nums[i++] == 0)
                nums[j++] = 0;
        }
        while(j < i)
            nums[j++] = 1;
    }
}

/*
解法二：遇到2就和尾指针交换，遇到0就和首指针交换，这样不用补1
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：37.4 MB, 在所有 Java 提交中击败了32.62% 的用户
*/
class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = 0;
        for(int k = nums.length - 1; i <= k; i++) {
            while(nums[i] == 2 && i <= k) {
                nums[i] = nums[k];
                nums[k--] = 2;
            }
            while(nums[i] == 0 && i >= j) {
                nums[i] = nums[j];
                nums[j++] = 0;
            }
        }
    }
}
