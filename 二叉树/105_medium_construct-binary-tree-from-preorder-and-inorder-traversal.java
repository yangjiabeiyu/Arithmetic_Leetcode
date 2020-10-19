/*
从前序与中序遍历序列构造二叉树
https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
根据一棵树的前序遍历与中序遍历构造二叉树。
注意:
你可以假设树中没有重复的元素。
例如，给出
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
*/

/*
解法：通过前序遍历得到根节点，在中序遍历中得到根节点的左右子节点
执行用时：2 ms, 在所有 Java 提交中击败了97.75% 的用户
内存消耗：38.6 MB, 在所有 Java 提交中击败了97.76% 的用户
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;
        Map<Integer, Integer> map = new HashMap<>();  // key:inorder[index]; value:index，放入hash表，便于后续确定元素的位置
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return fun(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    // preLeft/preRight/inLeft/inRight 子树中的所有节点的起始位置/终止位置（前序遍历与中序遍历）
    public TreeNode fun(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight, Map<Integer, Integer> map) {
        if(preLeft > preRight || inLeft > inRight)   // 终止条件
            return null;
        int rootVal = preorder[preLeft];             // 前序遍历的第一个就是根节点
        TreeNode root = new TreeNode(rootVal);       // 建立树节点
        int index = map.get(preorder[preLeft]);      // 找到根节点在中序遍历中的位置，左侧即是所有的左子节点[inLeft, index-1]，右侧即是所有的右子节点[index+1, inRight]
        root.left = fun(preorder, preLeft + 1, index + preLeft - inLeft, inorder, inLeft, index - 1, map);
        root.right = fun(preorder, index + preLeft - inLeft + 1, preRight, inorder, index + 1, inRight, map);
        return root;
    }
}

