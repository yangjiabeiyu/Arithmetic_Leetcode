/*
剑指 Offer 62. 圆圈中最后剩下的数字

0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。

示例 1：
输入: n = 5, m = 3
输出: 3
*/

/*
解法：f(n,m)表示n个数，每隔m删除一个，最后剩下的下标；在右n个数时删除第一个数的位置是m%n，此时以后面的元素为基点，记f(n-1,m) = x，那么最后剩下的数的位置为(m%n+x)%n=(m+x)%n。
因此可以得到递推关系：f(n,m) = (m+f(n-1,m))%n，f(1,m)=0;最后的0也可以先当作1，然后把最终得到的结果减1，其实结果一样的。
执行用时：7 ms, 在所有 Java 提交中击败了99.99% 的用户
内存消耗：34.9 MB, 在所有 Java 提交中击败了99.57% 的用户
*/
class Solution {
    public int lastRemaining(int n, int m) {
        int res = 0;
        for(int i = 2; i < n + 1; i++)
            res = (res + m) % i;
        return res;
    }
}


/*
解法二：使用list来模拟
执行用时：1127 ms, 在所有 Java 提交中击败了5.02% 的用户
内存消耗：40.6 MB, 在所有 Java 提交中击败了35.86% 的用户
*/
class Solution {
    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++)
            list.add(i);
        int index = 0;
        while(n > 1) {
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }
}

