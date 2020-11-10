/*
297. 二叉树的序列化与反序列化
https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。

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
解法：注意细节
执行用时：30 ms, 在所有 Java 提交中击败了32.37% 的用户
内存消耗：40.3 MB, 在所有 Java 提交中击败了82.31% 的用户
*/
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "[]";
        StringBuilder res = new StringBuilder();
        res.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if(p != null) {
                res.append(p.val + ",");
                queue.offer(p.left);
                queue.offer(p.right);
            }
                else res.append("null,");
        }
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if("[]".equals(data)) return null;
        String[] strs = data.substring(1, data.length() - 1).split(",");   // 这里不能用','
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));      // 字符串转数字
        queue.offer(root);
        int index = 1;
        while(!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if(!"null".equals(strs[index])) {
                p.left = new TreeNode(Integer.parseInt(strs[index]));
                queue.offer(p.left);
            }
            index++;
            if(!"null".equals(strs[index])) {
                p.right = new TreeNode(Integer.parseInt(strs[index]));
                queue.offer(p.right);
            }
            index++;
        }
        return root;
    }
}

