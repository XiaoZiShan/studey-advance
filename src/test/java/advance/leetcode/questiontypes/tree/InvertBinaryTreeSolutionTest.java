package advance.leetcode.questiontypes.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import studey.advance.leetcode.datastructure.tree.TreeNode;
import studey.advance.leetcode.questiontypes.tree.InvertBinaryTreeSolution;

/**
 * Created by !
 */

public class InvertBinaryTreeSolutionTest  extends InvertBinaryTreeSolution {
    @Test
    void invertTree(){
        //输入：root = [4,2,7,1,3,6,9]
        //输出：[4,7,2,9,6,3,1]
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(9);

        // 正确结果
        TreeNode treeNodeAssertions = new TreeNode(4);
        treeNodeAssertions.right = new TreeNode(2);
        treeNodeAssertions.right.right = new TreeNode(1);
        treeNodeAssertions.right.left = new TreeNode(3);
        treeNodeAssertions.left = new TreeNode(7);
        treeNodeAssertions.left.right = new TreeNode(6);
        treeNodeAssertions.left.left = new TreeNode(9);

        Assertions.assertEquals(treeNodeAssertions, super.invertTree(treeNode));
    }

    @Test
    void invertTreeX(){
        //输入：root = [4,2,7,1,3,6,9]
        //输出：[4,7,2,9,6,3,1]
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(3);
        treeNode.right = new TreeNode(7);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(9);

        // 正确结果
        TreeNode treeNodeAssertions = new TreeNode(4);
        treeNodeAssertions.right = new TreeNode(2);
        treeNodeAssertions.right.right = new TreeNode(1);
        treeNodeAssertions.right.left = new TreeNode(3);
        treeNodeAssertions.left = new TreeNode(7);
        treeNodeAssertions.left.right = new TreeNode(6);
        treeNodeAssertions.left.left = new TreeNode(9);

        Assertions.assertEquals(treeNodeAssertions, super.invertTreeX(treeNode));
    }
}
