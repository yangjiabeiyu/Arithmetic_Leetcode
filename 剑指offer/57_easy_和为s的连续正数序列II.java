/*
剑指 Offer 57 - II. 和为s的连续正数序列

输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

示例 1：

输入：target = 9
输出：[[2,3,4],[4,5]]
*/

/*
解法：利用求和公式计算sum，然后若比target大，则左侧后移；小，则右侧后移；相等，则记录数值。
本题的关键点也在于如何用二维数组存储，做法是先用list存储，再转为数组。
执行用时：5 ms, 在所有 Java 提交中击败了32.65% 的用户
内存消耗：36.3 MB, 在所有 Java 提交中击败了98.81% 的用户
*/
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        for(int i = 1, j = 2; i < j;) {
            int sum = (j - i + 1) * (i + j) / 2;
            if(sum > target)
                i++;
            else if(sum < target)
                j++;
            else {
                int[] arr = new int[j - i + 1];
                for(int k = 0; k < j - i + 1; k++)
                    arr[k] = i + k;
                list.add(arr);
                i++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}


/*
拓展：如果不知道公式，或者是遍历单调数组，可以先初始化sum
执行用时：2 ms, 在所有 Java 提交中击败了94.04% 的用户
内存消耗：36.3 MB, 在所有 Java 提交中击败了98.88% 的用户
*/

class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int sum = 3;
        for(int i = 1, j = 2; i < j;) {
            if(sum > target) {
                sum -= i;
                i++;
            }
            else if(sum < target) {
                j++;
                sum += j;
            }
            else {
                int[] arr = new int[j - i + 1];
                for(int k = 0; k < j - i + 1; k++)
                    arr[k] = i + k;
                list.add(arr);
                sum -= i;
                i++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}


/*
拓展二：不同的结束循环写法
执行用时：7 ms, 在所有 Java 提交中击败了18.72% 的用户
内存消耗：36.2 MB, 在所有 Java 提交中击败了99.41% 的用户
*/
class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int sum = 1, i = 1, j = 1;
        while(i <= target / 2) {
            if(sum > target) {
                sum -= i;
                i++;
            }
            else if(sum < target) {
                j++;
                sum += j;
            }
            else {
                int[] arr = new int[j - i + 1];
                for(int k = 0; k < j - i + 1; k++)
                    arr[k] = i + k;
                list.add(arr);
                sum -= i;
                i++;
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}


