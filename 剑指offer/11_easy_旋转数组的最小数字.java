/*
剑指 Offer 11. 旋转数组的最小数字

把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  

示例 1：
输入：[3,4,5,1,2]
输出：1

示例 2：
输入：[2,2,2,0,1]
输出：0
*/

/*
解法一：顺序查找
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.2 MB, 在所有 Java 提交中击败了95.97% 的用户
*/
class Solution {
    public int minArray(int[] numbers) {
        if(numbers.length == 1)
            return numbers[0];
        for(int i = 1; i < numbers.length; i++)
            if(numbers[i] < numbers[i - 1])
                return numbers[i];
        return numbers[0];
    }
}


/*
解法二：二分查找
如果nums[mid]>nums[right]，说明旋转点一定在[mid+1, right]，所以left = mid+1；
如果nums[mid]<nums[right]，说明旋转点一定在[left, mid]，所以right=mid；
如果nums[mid]=nums[right]，无法判定，但可以让right--来缩小区间，因为如果mid=right，也即是left=right，这样会跳出循环；所以必有mid<right，可以让right--。
执行用时：1 ms, 在所有 Java 提交中击败了45.00% 的用户
内存消耗：38.3 MB, 在所有 Java 提交中击败了94.04% 的用户
*/
class Solution {
    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while(left < right) {
            int mid = (right + left) / 2;
            if(numbers[mid] > numbers[right])
                left = mid + 1;
            else if(numbers[mid] < numbers[right])
                right = mid;
            else
                right--;
        }
        return numbers[left];
    }
}


