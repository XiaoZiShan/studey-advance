package studey.advance.questiontypes.tree;

import studey.advance.datastructure.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * https://leetcode-cn.com/problems/invert-binary-tree
 */
public class InvertBinaryTreeSolution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
    
        // 判断左子树或右子树都不为空, 递归调用
        if (root.left != null){
            this.invertTree(root.left);
        }
    
        if (root.right != null){
            this.invertTree(root.right);
        }
        
        // 替换左子树与右子树位置
        TreeNode tl = root.left;
        root.left = root.right;
        root.right = tl;
        
        return root;
    }
    
    public TreeNode invertTreeX(TreeNode root) {
        if(root==null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        // 将树放入
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            TreeNode temp=node.left;
            node.left=node.right;
            node.right=temp;
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
        return root;
    }
}