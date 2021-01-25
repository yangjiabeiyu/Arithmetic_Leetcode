/*
106. 从中序与后序遍历序列构造二叉树
https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
根据一棵树的中序遍历与后序遍历构造二叉树。
注意:
你可以假设树中没有重复的元素。
例如，给出
中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
*/

/*
执行用时：2 ms, 在所有 Java 提交中击败了98.14%的用户
内存消耗：38.7 MB, 在所有 Java 提交中击败了32.19%的用户
*/
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int leftIn, int rightIn, int leftPost, int rightPost, Map<Integer, Integer> map) {
        if(leftIn > rightIn || leftPost > rightPost) return null;
        TreeNode root = new TreeNode(postorder[rightPost]);
        int flagIndex = map.get(postorder[rightPost]);
        root.left = buildTree(inorder, postorder, leftIn, flagIndex - 1, leftPost, leftPost + flagIndex - leftIn - 1, map);
        root.right = buildTree(inorder, postorder, flagIndex + 1, rightIn, leftPost + flagIndex - leftIn, rightPost - 1, map);
        return root;
    }
}

