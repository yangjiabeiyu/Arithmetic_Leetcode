/*
278. 第一个错误的版本
https://leetcode-cn.com/problems/first-bad-version/
你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。

示例:
给定 n = 5，并且 version = 4 是第一个错误的版本。

调用 isBadVersion(3) -> false
调用 isBadVersion(5) -> true
调用 isBadVersion(4) -> true

所以，4 是第一个错误的版本。 
*/

/*
解法：二分，注意一点是使用 int mid = (right + left) / 2; 是有可能溢出的。
执行用时：16 ms, 在所有 Java 提交中击败了98.74% 的用户
内存消耗：35.1 MB, 在所有 Java 提交中击败了90.11% 的用户
*/
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid))
                right = mid;
            else
                left = mid + 1;
        }
        return right;
    }
}

