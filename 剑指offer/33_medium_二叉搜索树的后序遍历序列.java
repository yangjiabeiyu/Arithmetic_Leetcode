/*
剑指 Offer 33. 二叉搜索树的后序遍历序列
https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

参考以下这颗二叉搜索树：

     5
    / \
   2   6
  / \
 1   3

示例 1：
输入: [1,6,3,2,5]
输出: false

示例 2：
输入: [1,3,2,6,5]
输出: true
*/

/*
解法一：单调栈
对于后序遍历的倒序数组reverse，也就是按照中右左的顺序，如果reverse[i]<reverse[i+1]，那么i+1就是i的右子节点；
反之，那么i+1是前面的第一个大于i+1的元素(记为root)的左子节点。而且i+1后面都在root的左子树中，所以后面的元素都是小于root的。
执行用时：1 ms, 在所有 Java 提交中击败了23.02% 的用户
内存消耗：35.9 MB, 在所有 Java 提交中击败了91.72% 的用户
*/
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        int root = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<>();
        for(int i = postorder.length - 1; i >= 0; i--) {
            if(postorder[i] > root)
                return false;
            while(!stack.isEmpty() && stack.peek() > postorder[i])     // 找root
                root = stack.pop();
            stack.push(postorder[i]);
        }
        return true;
    }
}

/*
解法二：递归
末尾元素必然是根节点，然后从头遍历，小于root的都在左子树；后续的应该都在右子树，也就是需要大于root，如果不满足，那么就不是二叉搜索树。
执行用时：0 ms, 在所有 Java 提交中击败了100.00% 的用户
内存消耗：35.9 MB, 在所有 Java 提交中击败了90.43% 的用户
*/
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }
    public boolean verifyPostorder(int[] postorder, int left, int right) {
        if(left >= right - 1)
            return true;
        int index = left;
        while(postorder[index] < postorder[right])
            index++;
        int pos = index;    // 右子树的根节点
        while(postorder[index] > postorder[right])
            index++;
        return index == right && verifyPostorder(postorder, left, pos - 1) && verifyPostorder(postorder, pos, right - 1);
    }
}

