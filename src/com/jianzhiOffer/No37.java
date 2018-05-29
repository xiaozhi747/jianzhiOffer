package com.jianzhiOffer;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 * Created by 林智 on 2018/5/29.
 */
public class No37 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    String Serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        Serialize(root, sb);
        return sb.toString();
    }

    void Serialize(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        Serialize(root.left, sb);
        Serialize(root.right, sb);
    }
    // 注意  这个全局变量, 是必须的
    // 当头节点遍历到右子树的时候, 右子树的头节点所在的下标索引不应该是第一次递归时左子树的下一个,
    // 是不相邻的
    int index = -1;

    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] array = str.split(",");
        return Deserialize(array);
    }

    TreeNode Deserialize(String[] array) {
        index++;
        if (index != array.length && !array[index].equals("#")) {
            TreeNode root = new TreeNode(Integer.parseInt(array[index]));
            root.left = Deserialize(array);
            root.right = Deserialize(array);
            return root;
        }
        return null;
    }

}
