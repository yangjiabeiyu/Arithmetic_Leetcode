/*
剑指 Offer 03. 数组中重复的数字

找出数组中重复的数字。
在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：
输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3 
*/

/*
解法一：对于下标i，找到k = nums[i]，如果k小于0，就加n恢复原指向的数字，如果nums[k]<0，这说明之前有访问到k，返回k；否则就nums[k]-=n，表示来过一次k。空间复杂度为O(1)
执行用时：2 ms, 在所有 Java 提交中击败了68.36% 的用户
内存消耗：46 MB, 在所有 Java 提交中击败了96.65% 的用户
*/
class Solution {
    public int findRepeatNumber(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            int k = nums[i];
            if(k < 0) k += n;
            if(nums[k] < 0)
                return k;
            nums[k] -= n;
        }
        return -1;
    }
}

/*
解法二：哈希表存储
执行用时：9 ms, 在所有 Java 提交中击败了23.75% 的用户
内存消耗：47.4 MB, 在所有 Java 提交中击败了39.95% 的用户
*/
class Solution {
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); 
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]))
                return nums[i];
            map.put(nums[i], 1);
        }
        return -1;
    }
}

/*
解法三：hashset
执行用时：6 ms, 在所有 Java 提交中击败了39.48% 的用户
内存消耗：48.2 MB, 在所有 Java 提交中击败了22.89% 的用户
*/
class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            if (!set.add(num))
                return num;
        return -1;
    }
}

/*
解法四：用数组存储。
执行用时：1 ms, 在所有 Java 提交中击败了90.74% 的用户
内存消耗：45.8 MB, 在所有 Java 提交中击败了98.99% 的用户
*/
class Solution {
    public int findRepeatNumber(int[] nums) {
        int[] dp = new int[nums.length];
        for(int num : nums) {
            if(dp[num] == 1)
                return num;
            dp[num] += 1;
        }
        return -1;
    }
}

