/*
95. 不同的二叉搜索树 II
https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。

示例：
输入：3
输出：
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
解释：
以上的输出对应以下 5 种不同结构的二叉搜索树：

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

*/

/*
解法：递归，对于每个节点，左边的节点只能是比自己小的，右边的节点只能是比自己大的；所以可以从底层开始，往上返回可供选择的左子树的list和右子树的list
执行用时：1 ms, 在所有 Java 提交中击败了99.84% 的用户
内存消耗：39.2 MB, 在所有 Java 提交中击败了38.88% 的用户
*/
class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> curList = new ArrayList<>();
        if(start > end)
            curList.add(null);
        for(int i = start; i <= end; i++) {
            List<TreeNode> leftList = generateTrees(start, i - 1);  // 可供选择的左子树的集合
            List<TreeNode> rightList = generateTrees(i + 1, end);   // 右子树的列表
            for(TreeNode left : leftList)  // 遍历
                for(TreeNode right : rightList) {
                    TreeNode curNode = new TreeNode(i);
                    curNode.left = left;
                    curNode.right = right;
                    curList.add(curNode);
                }
        }
        return curList;
    }
}

