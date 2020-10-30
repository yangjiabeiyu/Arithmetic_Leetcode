/*
118. 杨辉三角
https://leetcode-cn.com/problems/pascals-triangle/
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:
输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

/*
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：36.5 MB, 在所有 Java 提交中击败了35.14% 的用户
*/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        if(numRows == 0) return new ArrayList();
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> preList = new ArrayList<>();     // 初始化第一行
        preList.add(1);
        lists.add(preList);
        for(int i = 1; i < numRows; i++) {
            List<Integer> curList = new ArrayList<>();
            curList.add(1);        // 先添加1
            for(int j = 0; j < i - 1; j++)
                curList.add(preList.get(j) + preList.get(j + 1));   // 中间取和
            curList.add(1);       // 最后加1
            lists.add(curList);
            preList = curList;
        }
        return lists;
    }
}

