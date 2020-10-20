/*
剑指 Offer 56 - I. 数组中数字出现的次数
一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
示例 1：

输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]

示例 2：

输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/

/*
解法：把所有数字分成两组，使得：两个只出现一次的数字在不同的组中；相同的数字会被分到相同的组中。
具体做法是，先求出所有数字的异或值，也就是目标值a和b的异或值，找到值为1的某位，这也说明a和b的该位不同；对于num，如果该位为1，则进组一；为0则进组二。然后分别计算异或值即可。
执行用时：2 ms, 在所有 Java 提交中击败了96.40% 的用户
内存消耗：40 MB, 在所有 Java 提交中击败了95.30% 的用户
*/
class Solution {
    public int[] singleNumbers(int[] nums) {
        int res = 0;
        for(int num : nums)
            res ^= num;
        int div = 1, one = 0, two = 0;
        while((div & res) == 0)      // 找到值为1的某位，既然是1，也就说明两个数字的该位是不同的
            div <<= 1;
        for(int num : nums)
            if((num & div) == 0)     // 说明num的该位是0
                one ^= num;
            else
                two ^= num;          // 说明num的该位是1
        return new int[] {one, two};
    }
}


