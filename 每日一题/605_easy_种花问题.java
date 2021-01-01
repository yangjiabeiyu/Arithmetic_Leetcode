/*
605. 种花问题
https://leetcode-cn.com/problems/can-place-flowers/
假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。

示例 1:
输入: flowerbed = [1,0,0,0,1], n = 1
输出: True

示例 2:
输入: flowerbed = [1,0,0,0,1], n = 2
输出: False

注意:
    数组内已种好的花不会违反种植规则。
    输入的数组长度范围为 [1, 20000]。
    n 是非负整数，且不会超过输入数组的大小。
*/

/*
贪心，遍历，检查前后，能种就种
执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：40 MB, 在所有 Java 提交中击败了48.16% 的用户
*/
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) return true;
        int i = 0, len = flowerbed.length;
        while(i < len) {
            if(flowerbed[i] == 1)  // 如果为1，就跳两步
                i = i + 2;
            else {
                if((i == 0 || flowerbed[i - 1] == 0) && (i == len - 1 || flowerbed[i + 1] == 0)) {  // 如果前后都为0，就种下，然后跳两步
                    flowerbed[i] = 1;
                    n--;
                    i = i + 2;
                }
                else i++;  // 否则就跳一步
            }
            if(n == 0) return true;
        }
        return false;
    }
}

/*
解法二：每次都跳两步
执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：39.9 MB, 在所有 Java 提交中击败了66.43% 的用户
*/
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n == 0) return true;
        int len = flowerbed.length;
        for(int i = 0; i < len; i += 2) {
            if(flowerbed[i] == 0) { // 如果为1，直接跳两步
                if(i == len - 1 || flowerbed[i + 1] == 0)  // 由于原数组是不会有相邻的1，所以当前位置为0，那么前面肯定不是1；如果前面是1，就会跳两步，也就是不会走到当前位置。因此只需要考虑后面的
                    n--;
                else i++; // 如果后面是1或者已经走到了尽头，那么i++
            }
            if(n == 0) return true;
        }
        return false;
    }
}

