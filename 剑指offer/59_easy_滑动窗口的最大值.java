/*
剑指 Offer 59 - I. 滑动窗口的最大值
给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

示例:

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7] 
解释: 

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

 

提示：

你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
解法一：自己的解法，在滑动时，记录下来之前的最大值的位置；如果新加入的元素大于等于最大值，那么就更新最大值的位置，并且continue；
如果小于最大值，那么就看看最大值的位置是否位于该区间，若在，那么就使用当前的最大值；如果不在，那么就遍历一遍窗口得到最大值，并更新最大值的位置。
执行用时：2 ms, 在所有 Java 提交中击败了97.44% 的用户
内存消耗：46 MB, 在所有 Java 提交中击败了97.55% 的用户
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0)
            return new int[0];
        int maxPos = -1, cnt = 0;
        int[] res = new int[nums.length - k + 1];
        int maxNum = Integer.MIN_VALUE;
        for(int j = 0; j < k; j++)                // 找初始的最大值及位置
            if(maxNum <= nums[j]) {
                maxNum = nums[j];
                maxPos = j;
            }
        res[cnt++] = maxNum;        // 记录下来
        for(int i = 1; i < nums.length - k + 1; i++) {
            if(nums[i+k-1] >= nums[maxPos]) {               // 如果新加入的≥最大值，就直接更新最大值
                res[cnt++] = nums[i+k-1];
                maxPos = i + k - 1;
            }
            else if(i <= maxPos)                       // 如果最大值还在该区间，那么就直接使用最大值
                res[cnt++] = nums[maxPos];
            else {                                     // 否则需要在该区间更新最大值及其位置
                maxNum = Integer.MIN_VALUE;
                for(int j = i; j < i + k; j++)
                    if(maxNum <= nums[j]) {
                        maxNum = nums[j];
                        maxPos = j;
                    }
                res[cnt++] = maxNum;
            }
        }
        return res;
    }
}


/*
解法二：对上述代码进行精简，可以考虑比较上次的最大值是不是nums[i-1]，也即是，是不是窗口滑动时把最大值给滑走了；如果不等，那就可以直接和新加入的元素比较得到新的最大值。
如果相等，那么就在新窗口中获取最大值。相较方法一，该方法计算更多一些，虽然nums[i-1]是res[i-1]，但也有可能窗口中有多个最大值，此时也并不需要在窗口遍历。
方法一实现了最大值位置的及时刷新，所以不存在这个问题。
执行用时：2 ms, 在所有 Java 提交中击败了97.44% 的用户
内存消耗：46.1 MB, 在所有 Java 提交中击败了96.79% 的用户
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0)
            return new int[0];
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length - k + 1; i++) {
            if(i != 0 && res[i - 1] != nums[i - 1])
                res[i] = Math.max(res[i - 1], nums[i + k - 1]);
            else {
                int maxNum = Integer.MIN_VALUE;
                for(int j = i; j < i + k; j++)
                    if(maxNum < nums[j])
                        maxNum = nums[j];
                res[i] = maxNum;
            }
        }
        return res;
    }
}


/*
解法三：单调队列。维护一个单调队列，从头到尾，依次递减。一开始，L不动，R右移，并且维护单调队列(放入下标)，当间隔为k-1时，那么就同时移动，并且要判断队首元素是否在窗口中。
执行用时：31 ms, 在所有 Java 提交中击败了32.98% 的用户
内存消耗：47.9 MB, 在所有 Java 提交中击败了98.41% 的用户
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0)
            return new int[0];
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length; i++) {
            while(!list.isEmpty() && nums[list.peekLast()] <= nums[i])        // 如果新来的元素更大，就让队尾出队列
                list.pollLast();
            list.offerLast(i);                                                // 放入新元素的下标
            if(i - k >= list.peekFirst())                                     // 如果该最大值已经不在窗口中，就从队首弹出
                list.pollFirst();
            if(i >= k - 1)                                                    // 如果已经构成了窗口，就更新res数组
                res[i - k + 1] = nums[list.peekFirst()];
        }
        return res;
    }
}

