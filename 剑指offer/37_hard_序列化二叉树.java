/*
剑指 Offer 37. 序列化二叉树
https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
请实现两个函数，分别用来序列化和反序列化二叉树。

示例: 
你可以将以下二叉树：

    1
   / \
  2   3
     / \
    4   5

序列化为 "[1,2,3,null,null,4,5]"
*/

/*
解法：层序遍历，可以迭代完成；反序列化时，也可以借助队列来完成操作，不过完成本题主要是对一些方法的应用，设置分隔符等。
执行用时：28 ms, 在所有 Java 提交中击败了24.66% 的用户
内存消耗：41 MB, 在所有 Java 提交中击败了41.36% 的用户
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "[]";
        StringBuilder sb = new StringBuilder("[");  // 此处初始化需要传入字符串，不能传入字符
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if(p != null) {
                sb.append(p.val + ",");
                queue.offer(p.left);
                queue.offer(p.right);
            }
            else
                sb.append("null,");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(']');
        return sb.toString();      
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("[]".equals(data)) return null;
        String[] vals = data.substring(1, data.length() - 1).split(",");    // 分割为字符串数组
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));   // 将字符串转为数字
        Queue<TreeNode> queue = new LinkedList<>() {{ offer(root); }};
        int index = 1;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(!"null".equals(vals[index])) {       // 先左后右，如果是null可不做处理，因为没有子节点
                node.left = new TreeNode(Integer.parseInt(vals[index]));
                queue.offer(node.left);
            }
            index++;
            if(!"null".equals(vals[index])) {
                node.right = new TreeNode(Integer.parseInt(vals[index]));
                queue.offer(node.right);
            }
            index++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

