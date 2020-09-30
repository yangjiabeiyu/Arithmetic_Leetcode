/*
三数之和
https://leetcode-cn.com/problems/3sum/
题目描述
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
注意：答案中不可以包含重复的三元组。
示例
给定数组 nums = [-1, 0, 1, 2, -1, -4]，满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

/*
解法：
1、为了保证不重复，是需要提前排序的，这样可以设置三重循环；如果两次循环使用的数字相同，则直接continue
2、减少循环的思路在于只剩二重循环时，两者加和的目标值是相同的，所以循环2增加时，循环3必会在此前的基础上减少(即前移)；因此循环3可省略，变为从n往前遍历。
执行用时：24 ms, 在所有 Java 提交中击败了70.04% 的用户
内存消耗：42.9 MB, 在所有 Java 提交中击败了33.82% 的用户
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);  // 对数组排序
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {  // 一重循环
            if(i == 0 || nums[i] != nums[i-1]) {  // 如果前后数值不同则开启二重循环
                int k = nums.length - 1;  // 从n开始向前遍历
                for(int j = i + 1; j < nums.length; j++) {  // 开启二重
                    if(j == i + 1 || nums[j] != nums[j-1]) {  // 需要保证前后数值不同
                        int target = -nums[i] - nums[j];  // 第三个数字的目标值
                        while(k > j && nums[k] > target)  // 如果当前数值较大则向前寻找更小的
                            k--;
                        if(k == j)  // 如果k到了j还没找到更小的，那么后续j增加，就更找不到更小的k了，所以就break
                            break;
                        if(nums[k] == target) {  //如果恰好满足，那么就添加到列表之中
                            List<Integer> list0 = new ArrayList<>();
                            list0.add(nums[i]);
                            list0.add(nums[j]);
                            list0.add(nums[k]);
                            list.add(list0);
                        }
                    }
                }
            }

        }
        return list;
    }
}
