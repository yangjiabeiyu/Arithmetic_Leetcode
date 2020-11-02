/*
349. 两个数组的交集
https://leetcode-cn.com/problems/intersection-of-two-arrays/
给定两个数组，编写一个函数来计算它们的交集。

示例 1：
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]

示例 2：
输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]

说明：
    输出结果中的每个元素一定是唯一的。
    我们可以不考虑输出结果的顺序。
*/

/*
解法一：使用map<Integer, Boolean>存储数组一，然后遍历数组二，遇到后就取false
执行用时：3 ms, 在所有 Java 提交中击败了95.82% 的用户
内存消耗：38.6 MB, 在所有 Java 提交中击败了88.65% 的用户
*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++)      // 放入map中
            map.put(nums1[i], true);
        for(int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i]) && map.get(nums2[i])) {
                res.add(nums2[i]);
                map.put(nums2[i], false);       // 标志已取过
            }
        }
        int[] rest = new int[res.size()];
        for(int i = 0; i < res.size(); i++)   // 列表转数组
            rest[i] = res.get(i);
        return rest;
    }
}

/*
解法二：可以使用set存储数组一，遍历数组二，删除set中加入结果的数字。
执行用时：5 ms, 在所有 Java 提交中击败了28.20% 的用户
内存消耗：38.8 MB, 在所有 Java 提交中击败了79.33% 的用户
*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for(int num : nums1)
            set.add(num);
        for(int num : nums2)
            if(set.contains(num)) {
                res.add(num);
                set.remove(num);
            }
        return res.stream().mapToInt(Integer::intValue).toArray();   // 列表转数组
    }
}

