/*
旋转数组
https://leetcode-cn.com/problems/rotate-array/
题目描述
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
示例:
输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
要求使用空间复杂度为 O(1) 的 原地 算法。
*/

/*
解法一：取出数组最后一个元素e，其余元素后移一位，再将e放到首元素位置，重复k次；复杂度O(k*n)
执行用时：266 ms, 在所有 Java 提交中击败了20.57% 的用户
内存消耗：39.4 MB, 在所有 Java 提交中击败了49.85% 的用户
*/
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length <= 1)
            return;
        int flag, i, j;
        k %= nums.length;
        for(j = 0; j < k; j++) {
            flag = nums[nums.length - 1];
            for(i = nums.length - 1; i > 0; i--)
                nums[i] = nums[i-1];
            nums[0] = flag;
        }
    }
}

/*
解法二：先将数组反转，然后将前k个元素反转，再将后n-k个反转
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：39.7 MB, 在所有 Java 提交中击败了8.82% 的用户
*/
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length <= 1)
            return;
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public static void reverse(int[] nums, int start, int end) {
        int temp;
        while(start < end) {
            temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}

/*
解法三：数组从元素(pos,ele)开始，找应该属于自己的座位pos+k；pos+k处的元素离开去找属于自己的座位，不断循环；如果形成一个环状，即走到了ele的位置，则开始下一个元素的换座。由于最多换位n次，所以可设置计数来终止数组遍历。
*/
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length <= 1)
            return;
        k %= nums.length;
        int count = 0, current, value1, value2;
        for(int start = 0; count < nums.length; start++) {
            current = start;  //记录当前位置
            value1 = nums[start];  //记录当前位置的元素
            do{
                current = (current + k) % nums.length;  //找到新的位置
                value2 = nums[current];  //记录下新位置的元素
                nums[current] = value1;  //"坐入"新位置
                value1 = value2;  //新位置的元素开始继续往下寻找
                count++;
            } while(start != current);  //如果回到了初始位置，那么终止循环，让下一个元素继续更新
        }
    }
}
