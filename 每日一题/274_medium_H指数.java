/*
274. H 指数
https://leetcode-cn.com/problems/h-index/
给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。
h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。
且其余的 N - h 篇论文每篇被引用次数 不超过 h 次。
例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。

示例：
输入：citations = [3,0,6,1,5]
输出：3 
解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
     由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
*/

/*
解法：排序即可，然后从大到小比较元素值与下标值
执行用时：1 ms, 在所有 Java 提交中击败了84.55% 的用户
内存消耗：36.1 MB, 在所有 Java 提交中击败了81.70% 的用户
*/
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);
        for(int i = 1; i <= n; i++)
            if(citations[n - i] < i)
                return i - 1;
        return n;
    }
}

/*
计数排序，因为h指数必然是不大于n的，所以大于n的元素和n是等价的，这样数组里面的元素值的范围就固定在0~n，然后构建数组统计次数就行了。O(n)的复杂度
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：36.1 MB, 在所有 Java 提交中击败了81.48% 的用户
*/
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] cnt = new int[n + 1];
        for(int i = 0; i < n; i++)
            cnt[Math.min(citations[i], n)]++;
        int sum = cnt[n], i = n - 1;
        for(; i >= 0 && sum <= i; i--)
            sum += cnt[i];
        return i + 1;
    }
}


// 另一种写法
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] cnt = new int[n + 1];
        for(int i = 0; i < n; i++)
            cnt[Math.min(citations[i], n)]++;
        int i = n;
        for(int sum = cnt[n]; i > sum; sum += cnt[i])
            i--;
        return i;
    }
}
