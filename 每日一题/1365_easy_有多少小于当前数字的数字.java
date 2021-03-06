/*
1365. 有多少小于当前数字的数字
https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
以数组形式返回答案。

示例 1：
输入：nums = [8,1,2,2,3]
输出：[4,0,1,1,3]
解释： 
对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。 
对于 nums[1]=1 不存在比它小的数字。
对于 nums[2]=2 存在一个比它小的数字：（1）。 
对于 nums[3]=2 存在一个比它小的数字：（1）。 
对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。

示例 2：
输入：nums = [6,5,4,8]
输出：[2,1,0,3]

示例 3：
输入：nums = [7,7,7,7]
输出：[0,0,0,0]

提示：
    2 <= nums.length <= 500
    0 <= nums[i] <= 100
*/

/*
解法一：深拷贝原数组，进行排序，然后hash表存储小于的个数，之后逐个得到原数组各元素对应的结果
执行用时：5 ms, 在所有 Java 提交中击败了69.49% 的用户
内存消耗：38.2 MB, 在所有 Java 提交中击败了98.66% 的用户
*/
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int[] numsCopy = new int[n], res = new int[n];
        for(int i = 0; i < n; i++)
            numsCopy[i] = nums[i];
        Arrays.sort(numsCopy);
        for(int i = 0; i < n; i++)
            map.put(numsCopy[i], map.getOrDefault(numsCopy[i], i));
        for(int i = 0; i < n; i++)
            res[i] = map.get(nums[i]);
        return res;
    }
}

/*
解法二：使用二维数组记录元素及其下标，然后对元素进行排序，之后统计次数即可。
执行用时：6 ms, 在所有 Java 提交中击败了66.41% 的用户
内存消耗：38.2 MB, 在所有 Java 提交中击败了98.97% 的用户
*/
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (v1, v2) -> v1[0] - v2[0]);
        int index = -1;
        for(int i = 0; i < n; i++) {
            if(index == -1 || arr[i][0] != arr[i - 1][0])       // 找到比当前元素小的元素个数
                index = i;
            res[arr[i][1]] = index;
        }
        return res;
    }
}

/*
解法三：注意到元素的取值范围为0~100，因此可以创建长度为101的数组，统计各元素出现的次数，然后依次叠加得到小于当前元素的元素个数。
执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：38.5 MB, 在所有 Java 提交中击败了94.57% 的用户
*/
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] arr = new int[101], res = new int[n];
        for(int i = 0; i < n; i++)
            arr[nums[i]]++;
        for(int i = 1; i < 101; i++)
            arr[i] += arr[i - 1];
        for(int i = 0; i < n; i++)
            res[i] = nums[i] == 0 ? 0 : arr[nums[i] - 1];
        return res;
    }
}

