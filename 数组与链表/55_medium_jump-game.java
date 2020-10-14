/*
跳跃游戏
https://leetcode-cn.com/problems/jump-game/
题目描述
给定一个非负整数数组，你最初位于数组的第一个位置。数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个位置。
示例 
输入: [2,3,1,1,4]    输出: true
解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
*/

/*
解法：贪心算法，不断得到能走到的最大距离，一旦发现，所处位置比最大距离还要大，就是false
执行用时：2 ms, 在所有 Java 提交中击败了80.90% 的用户
内存消耗：40.6 MB, 在所有 Java 提交中击败了86.61% 的用户
*/
class Solution {
    public boolean canJump(int[] nums) {
        int dis = 0;    // 存储最远能到达的地方，能到某个地方，说明前面的地方都能走到
        for(int i = 0; i < nums.length; i++) {
            if(i > dis)
                return false;
            dis = Math.max(i + nums[i], dis);
        }
        return true;
    }
}
