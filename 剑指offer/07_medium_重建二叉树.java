/*
剑指 Offer 07. 重建二叉树

输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

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
解法：递归。利用先序遍历得到根节点，然后在中序遍历中定位其位置，左边即是左子树，右边即是右子树。
执行用时：2 ms, 在所有 Java 提交中击败了98.10% 的用户
内存消耗：38.8 MB, 在所有 Java 提交中击败了86.12% 的用户
*/
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return fun(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    public TreeNode fun(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight, Map<Integer, Integer> map) {
        if(preLeft > preRight || inLeft > inRight)
            return null;
        int val = preorder[preLeft];
        TreeNode root = new TreeNode(val);
        int index = map.get(val);
        root.left = fun(preorder, preLeft + 1, preLeft + index - inLeft, inorder, inLeft, index - 1, map);
        root.right = fun(preorder, preLeft + index - inLeft + 1, preRight, inorder, index + 1, inRight, map);
        return root;
    }
}

