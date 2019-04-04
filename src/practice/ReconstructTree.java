package practice;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ReconstructTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
//            pre
            if (this != null) {
                sb.append(this.val);
            }
            if (left != null) {
                sb.append(this.left);
            }
            if (right != null) {
                sb.append(this.right);
            }


//            if (this != null) {
//                sb.append(this.val).append(" ");
//            }
//            if (left != null) {
//                sb.append(this.left).append(" ");
//            }
//            if (right != null) {
//                sb.append(this.right).append(" ");
//            }
//
//
//            if (left != null) {
//                sb.append(this.left).append(" ");
//            }
//            if (right != null) {
//                sb.append(this.right).append(" ");
//            }
//            if (this != null) {
//                sb.append(this.val).append(" ");
//            }
            return sb.toString();
        }
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0 || pre.length != in.length) {
            return null;
        }
//        System.out.println(Arrays.toString(pre));
        TreeNode tree = null;
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                tree = new TreeNode(pre[0]);
                tree.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1),
                                                            Arrays.copyOfRange(in, 0, i));
                tree.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i +1, pre.length),
                        Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return tree;
    }

//    输入某二叉树的前序遍历和中序遍历的结果，
// 请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列
// {1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

    public static void main(String[] args) {
        System.out.println(reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6}));
        System.out.println(reConstructBinaryTree(new int[]{ 10,2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6}));
//        reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
//        reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
//        reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
//        reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
    }

}
